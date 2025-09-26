package carlos.trujo.rentas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double monto;

    @Column
    private String direccion;

    @Column
    private boolean amueblado;

    @Column
    private int habitaciones;

    @Column
    private int sanitarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isAmueblado() {
        return amueblado;
    }

    public void setAmueblado(boolean amueblado) {
        this.amueblado = amueblado;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getSanitarios() {
        return sanitarios;
    }

    public void setSanitarios(int sanitarios) {
        this.sanitarios = sanitarios;
    }

}
