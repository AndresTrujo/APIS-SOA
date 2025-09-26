package com.trujo.entregas_loga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trujo.entregas_loga.model.PaquetesModel;
import com.trujo.entregas_loga.repository.PaquetesRepository;

@Service
public class PaquetesService {

    @Autowired
    private final PaquetesRepository paquetesRepository;

    public PaquetesService(PaquetesRepository paquetesRepository) {
        this.paquetesRepository = paquetesRepository;
    }

    public List<PaquetesModel> findAll() {
        return paquetesRepository.findAll();
    }

    public Optional<PaquetesModel> findById(Long id){
        return paquetesRepository.findById(id);
    }

    public PaquetesModel save(PaquetesModel paquete){
        return paquetesRepository.save(paquete);
    }

    public void deleteById(Long id) {
        paquetesRepository.deleteById(id);
    }

        // Falta el metodo update
}