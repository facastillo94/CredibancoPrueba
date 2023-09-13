package com.credibanco.CredibancoBack.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="transaccion")
public class TransaccionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaccion;

    @Column
    private Long id_tarjeta_transaccion;

    @Column
    private double monto_transaccion;

    @Column
    private Date fecha_transaccion;

    @Column
    private int anulado;

    public Long getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(Long id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Long getId_tarjeta_transaccion() {
        return id_tarjeta_transaccion;
    }

    public void setId_tarjeta_transaccion(Long id_tarjeta_transaccion) {
        this.id_tarjeta_transaccion = id_tarjeta_transaccion;
    }

    public double getMonto_transaccion() {
        return monto_transaccion;
    }

    public void setMonto_transaccion(double monto_transaccion) {
        this.monto_transaccion = monto_transaccion;
    }

    public Date getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(Date fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public int getAnulado() {
        return anulado;
    }

    public void setAnulado(int anulado) {
        this.anulado = anulado;
    }
}
