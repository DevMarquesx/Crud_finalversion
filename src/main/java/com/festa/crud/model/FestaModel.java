package com.festa.crud.model;

import java.util.UUID;

import com.festa.crud.dto.FestaDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "festa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FestaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private String presente;
	
	public FestaModel(FestaDto Dto) {
		this.nome = Dto.nome();
		this.presente = Dto.presente();
	}

//	public UUID getId() {
//		return id;
//	}
//
//	public void setId(UUID id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getPresente() {
//		return presente;
//	}
//
//	public void setPresente(String presente) {
//		this.presente = presente;
//	}


}
