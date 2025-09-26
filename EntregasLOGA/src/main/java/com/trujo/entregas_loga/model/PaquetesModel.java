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
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PaquetesModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientesModel cliente;

    @Column (name = "descripcion")
    private String descripcion;

    @Column (name = "estado")
    private double peso_kg;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", insertable = false, updatable = false )
    private EstadoEnum estado;

    @Column(name="fecha_entrega_estimada")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fecha_entrega_estimada;

    @CreationTimestamp
    @Column(name="created_at")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RutaPaqueteModel> rutaPaquetes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientesModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientesModel cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso_kg = peso_kg;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    public Date getFecha_entrega_estimada() {
        return fecha_entrega_estimada;
    }

    public void setFecha_entrega_estimada(Date fecha_entrega_estimada) {
        this.fecha_entrega_estimada = fecha_entrega_estimada;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public List<RutaPaqueteModel> getRutaPaquetes() {
        return rutaPaquetes;
    }

    public void setRutaPaquetes(List<RutaPaqueteModel> rutaPaquetes) {
        this.rutaPaquetes = rutaPaquetes;
    }

    


    
}
