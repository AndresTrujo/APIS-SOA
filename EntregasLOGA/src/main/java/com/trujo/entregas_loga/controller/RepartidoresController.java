package com.trujo.entregas_loga.controller;

import java.util.List;
import java.util.Optional;

import com.trujo.entregas_loga.model.RepartidoresModel;
import com.trujo.entregas_loga.service.RepartidoresService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@RestController
@Controller
@RequestMapping("/api/repartidores")
public class RepartidoresController {
    
    @Autowired
    private final RepartidoresService repartidorService;

    public RepartidoresController(RepartidoresService repartidorService) {
        this.repartidorService = repartidorService;
    }

    @GetMapping
    public List<RepartidoresModel> getAllRepartidores() {
        return repartidorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepartidoresModel> getRepartidorById(@PathVariable Long id) {
        return repartidorService.findById(id)
                .map(repartidor -> ResponseEntity.ok(repartidor))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
    }

    @PostMapping
    public ResponseEntity<RepartidoresModel> createRepartidor(@RequestBody RepartidoresModel repartidor) {
        RepartidoresModel nuevoRepartidor = repartidorService.save(repartidor);
        return new ResponseEntity<>(nuevoRepartidor, HttpStatus.CREATED); // Devuelve 201 Created
    }

    @PutMapping("/{id}")
    public RepartidoresModel updateRepartidor(@PathVariable Long id, @RequestBody RepartidoresModel repartidorDetails) {
        RepartidoresModel repartidor = repartidorService.updateRepartidor(id, repartidorDetails);
        return repartidor;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepartidor(@PathVariable Long id) {
        Optional<RepartidoresModel> repartidor = repartidorService.findById(id);
        if (repartidor.isPresent()){
            repartidorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devuelve 204 No Content
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve 404 Not Found
        }
    }

    @GetMapping("/listRepartidores")
    public String renderTotalRepartidores(Model model) {
        List<RepartidoresModel> repartidores = repartidorService.findAll();
        model.addAttribute("repartidores", repartidores);
        return "layout"; // Return the name of the template file (without extension)
    }

}
