package com.recorrido.ambiente.Service;

import java.util.List;
import java.util.Optional;

import com.recorrido.ambiente.Model.Ambiente;

public interface AmbienteService {
    
    public List<Ambiente> findAll();

    Ambiente save(Ambiente ambiente);

    public Optional<Ambiente> findById(String id);
}
