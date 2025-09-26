package com.trujo.entregas_loga.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "repartidores")
public class RepartidoresModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "nombre")
    private String nombre;

    @Column(length = 15, name = "telefono")
    private Long telefono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "vehiculo")
    private VehiculoEnum vehiculo;

    @Column(length = 20, name = "placa_vehiculo")
    private String placa_vehiculo;

    @Column(nullable = false)
    private Boolean activo = true;

    @CreationTimestamp
    @Column(name="created_at")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "repartidor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RutasModel> rutas;

    @OneToMany(mappedBy = "repartidor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeguimientoGpsModel> seguimientoGps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public VehiculoEnum getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEnum vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPlaca_vehiculo() {
        return placa_vehiculo;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public List<RutasModel> getRutas() {
        return rutas;
    }

    public void setRutas(List<RutasModel> rutas) {
        this.rutas = rutas;
    }

    public List<SeguimientoGpsModel> getSeguimientoGps() {
        return seguimientoGps;
    }

    public void setSeguimientoGps(List<SeguimientoGpsModel> seguimientoGps) {
        this.seguimientoGps = seguimientoGps;
    }


    
    
}

