package com.trujo.entregas_loga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trujo.entregas_loga.model.PaquetesModel;
import com.trujo.entregas_loga.service.PaquetesService;


@RestController
@RequestMapping("/api/paquetes")
public class PaquetesController {
    
    @Autowired
    private final PaquetesService paqueteService;

    public PaquetesController(PaquetesService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @GetMapping
    public ResponseEntity<List<PaquetesModel>> getAllPaquetes() {
        return ResponseEntity.ok(paqueteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaquetesModel> getPaqueteById(@PathVariable Long id) {
        return paqueteService.findById(id)
                .map(paquete -> ResponseEntity.ok(paquete))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    }

    @PostMapping
    public ResponseEntity<PaquetesModel> createRepartidor(@RequestBody PaquetesModel paquete) {
        PaquetesModel nuevoPaquete = paqueteService.save(paquete);
        return new ResponseEntity<>(nuevoPaquete, HttpStatus.CREATED); // Devuelve 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaquetesModel> updateRepartidor(@PathVariable Long id, @RequestBody PaquetesModel paqueteDetails) {
        return paqueteService.findById(id)
                .map(paquete -> {
                    paquete.setDescripcion(paqueteDetails.getDescripcion());
                    paquete.setPeso_kg(paqueteDetails.getPeso_kg());
                    paquete.setEstado(paqueteDetails.getEstado());
                    paquete.setFecha_entrega_estimada(paqueteDetails.getFecha_entrega_estimada());
                    return ResponseEntity.ok(paqueteService.save(paquete));
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Devuelve 404 si no se encuentra
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaquete(@PathVariable Long id) {
        paqueteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devuelve 204 No Content
    }

    
    

}
