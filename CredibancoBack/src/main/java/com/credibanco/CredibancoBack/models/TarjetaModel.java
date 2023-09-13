/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.credibanco.CredibancoBack.models;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Fabian Castillo
 */
@Entity
@Table(name = "tarjeta")
public class TarjetaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarjeta;

    @Column
    private String numeroproducto;

    @Column
    private String numerotarjeta;

    @Column
    private Date fechacreacion;

    @Column
    private Date fechavencimiento;

    @Column
    private double saldo;

    @Column
    private int activa_tarjeta;

    @Column
    private int bloqueada_tarjeta;

    public Long getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(Long id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public String getNumeroproducto() {
        return numeroproducto;
    }

    public void setNumeroproducto(String numeroproducto) {
        this.numeroproducto = numeroproducto;
    }

    public String getNumerotarjeta() {
        return numerotarjeta;
    }

    public void setNumerotarjeta(String numerotarjeta) {
        this.numerotarjeta = numerotarjeta;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getActiva_tarjeta() {
        return activa_tarjeta;
    }

    public void setActiva_tarjeta(int activa_tarjeta) {
        this.activa_tarjeta = activa_tarjeta;
    }

    public int getBloqueada_tarjeta() {
        return bloqueada_tarjeta;
    }

    public void setBloqueada_tarjeta(int bloqueada_tarjeta) {
        this.bloqueada_tarjeta = bloqueada_tarjeta;
    }
}
