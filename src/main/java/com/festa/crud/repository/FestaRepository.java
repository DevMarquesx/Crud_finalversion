package com.festa.crud.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.festa.crud.model.FestaModel;

@Repository
public interface FestaRepository extends JpaRepository<FestaModel, UUID> {}
