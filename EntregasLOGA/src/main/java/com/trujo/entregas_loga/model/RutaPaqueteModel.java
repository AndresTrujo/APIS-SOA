package com.trujo.entregas_loga.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutas_paquetes")
public class RutaPaqueteModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private RutasModel ruta;

    @ManyToOne
    @JoinColumn(name = "paquete_id")
    private PaquetesModel paquete;

    @Column(name = "orden_entrega")
    private Long orden_entrega;

    @Column(name = "entregado")
    private boolean entregado;

    @Column(name="fecha_entrega")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fecha_entrega;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RutasModel getRuta() {
        return ruta;
    }

    public void setRuta(RutasModel ruta) {
        this.ruta = ruta;
    }

    public PaquetesModel getPaquete() {
        return paquete;
    }

    public void setPaquete(PaquetesModel paquete) {
        this.paquete = paquete;
    }

    public Long getOrden_entrega() {
        return orden_entrega;
    }

    public void setOrden_entrega(Long orden_entrega) {
        this.orden_entrega = orden_entrega;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public LocalDateTime getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDateTime fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    
}
