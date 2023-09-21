package com.recorrido.ambiente.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recorrido.ambiente.Model.Ambiente;

public interface AmbienteRepository extends JpaRepository<Ambiente,String> {
    
    List<Ambiente> findAll();

    Optional<Ambiente> findById(String id);
}
