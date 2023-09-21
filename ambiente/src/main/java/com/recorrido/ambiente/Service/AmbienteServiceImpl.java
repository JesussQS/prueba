package com.recorrido.ambiente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recorrido.ambiente.Model.Ambiente;
import com.recorrido.ambiente.Repository.AmbienteRepository;

@Service
public class AmbienteServiceImpl implements AmbienteService {

    @Autowired
    private AmbienteRepository ambienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ambiente> findAll() {
        return ambienteRepository.findAll();
    }

    @Override
    @Transactional
    public Ambiente save(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ambiente> findById(String id) {
        return ambienteRepository.findById(id);
    }
    
}
