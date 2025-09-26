package com.trujo.entregas_loga.model;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;

@Entity(name = "rutas")
public class RutasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "repartidor_id")
    private RepartidoresModel repartidor;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum estado;

    @Column(name = "km_estimados")
    private double km_estimados;

    @CreationTimestamp
    @Column(name="created_at")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RutaPaqueteModel> rutaPaquetes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RepartidoresModel getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(RepartidoresModel repartidor) {
        this.repartidor = repartidor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getKm_estimados() {
        return km_estimados;
    }

    public void setKm_estimados(double km_estimados) {
        this.km_estimados = km_estimados;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    
}
