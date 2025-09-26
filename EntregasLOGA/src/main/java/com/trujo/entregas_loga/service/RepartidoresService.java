package com.trujo.entregas_loga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.trujo.entregas_loga.model.RepartidoresModel;
import com.trujo.entregas_loga.repository.RepartidoresRepository;

@Service
public class RepartidoresService {
    @Autowired
    private final RepartidoresRepository repartidorRepository;

    public RepartidoresService(RepartidoresRepository repartidorRepository) {
        this.repartidorRepository = repartidorRepository;
    }

    public List<RepartidoresModel> findAll() {
        return repartidorRepository.findAll();
    }

    public Optional<RepartidoresModel> findById(Long id) {
        return repartidorRepository.findById(id);
    }

    public RepartidoresModel save(RepartidoresModel repartidor) {
        return repartidorRepository.save(repartidor);
    }

    public void deleteById(Long id) {
        repartidorRepository.deleteById(id);
    }

    // Falta el metodo update
    public RepartidoresModel updateRepartidor(Long id, RepartidoresModel nuevoRepartidor){
        return repartidorRepository.findById(id)
                .map(repartidor -> {
                    repartidor.setNombre(nuevoRepartidor.getNombre());
                    repartidor.setTelefono(nuevoRepartidor.getTelefono());
                    repartidor.setPlaca_vehiculo(nuevoRepartidor.getPlaca_vehiculo());
                    repartidor.setVehiculo(nuevoRepartidor.getVehiculo());
                    repartidor.setActivo(nuevoRepartidor.isActivo());
                    save(repartidor);
                    return repartidor;
                })
                .orElse(null);
        
    }

}
