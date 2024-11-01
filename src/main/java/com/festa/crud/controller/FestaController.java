package com.festa.crud.controller;

import java.util.Optional;
import java.util.UUID;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.festa.crud.dto.FestaDto;
import com.festa.crud.model.FestaModel;
import com.festa.crud.repository.FestaRepository;

@RestController
@RequestMapping("api")
public class FestaController {

	@Autowired
	FestaRepository repo;
	@GetMapping
	public ResponseEntity getAll() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FestaModel> obterFestaPorId(@PathVariable UUID id) {
		Optional<FestaModel> festa = repo.findById(id);
	        
		if (festa.isPresent()) {
	            return ResponseEntity.ok(festa.get()); 
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }


	
	@PostMapping
	public ResponseEntity<FestaModel> criarFesta(@RequestBody FestaDto festaDto) {
        FestaModel festa = new FestaModel(festaDto);
        repo.save(festa);
        return ResponseEntity.status(201).body(festa);
	}
	

	  @PutMapping("/{id}")
    public ResponseEntity<FestaModel> atualizarFesta(@PathVariable UUID id, @RequestBody FestaDto festaDto) {
        Optional<FestaModel> festaExistente = repo.findById(id);
        
        if (festaExistente.isPresent()) {
            FestaModel festa = festaExistente.get();
            festa.setNome(festaDto.nome());
            festa.setPresente(festaDto.presente());

            
            repo.save(festa);
            return ResponseEntity.ok(festa); 
        } else {
            return ResponseEntity.notFound().build(); 
        	}
	  }
	  
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarFesta(@PathVariable UUID id) {
	        if (repo.existsById(id)) {
	            repo.deleteById(id); 
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

}