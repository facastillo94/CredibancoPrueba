/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.credibanco.CredibancoBack.services;

import com.credibanco.CredibancoBack.models.TarjetaModel;
import com.credibanco.CredibancoBack.models.TransaccionModel;
import com.credibanco.CredibancoBack.repositories.ITarjetaRepository;
import com.credibanco.CredibancoBack.repositories.ITransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Fabian Castillo
 */
@Service
public class TarjetaService {
    @Autowired
    ITarjetaRepository tarjetaRepository;

    public ArrayList<TarjetaModel> getTarjetas(){
        return (ArrayList<TarjetaModel>) tarjetaRepository.findAll();
    }

    public TarjetaModel saveTarjeta(TarjetaModel tarjeta){
        return tarjetaRepository.save(tarjeta);
    }

    public Optional<TarjetaModel> getById(Long id){
        return tarjetaRepository.findById(id);
    }
    public ArrayList<TarjetaModel> getBynumerotarjeta(String numerotarjeta){
        return tarjetaRepository.findBynumerotarjeta(numerotarjeta);
    }
    public Boolean deleteTarjeta (Long id){
        try{
            TarjetaModel tarjeta = tarjetaRepository.findById(id).get();
            tarjeta.setBloqueada_tarjeta(1);//BLOQUEAR TARJETA
            this.saveTarjeta(tarjeta);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public TarjetaModel updateById(TarjetaModel request, Long id){
        TarjetaModel tarjeta = tarjetaRepository.findById(id).get();
        tarjeta.setBloqueada_tarjeta(request.getBloqueada_tarjeta());
        tarjeta.setActiva_tarjeta(request.getActiva_tarjeta());
        this.saveTarjeta(tarjeta);
        return tarjeta;
    }

    public TarjetaModel updateBalance(Long id, double balance_final, double saldoacargar){
        TarjetaModel tarjeta = tarjetaRepository.findById(id).get();
        TransaccionModel transaccion = new TransaccionModel();
        tarjeta.setSaldo(balance_final);
        //SETEAMOS LA TRANSACCION PARA PODERLA INGRESAR
        transaccion.setId_tarjeta_transaccion(id);
        transaccion.setAnulado(0);
        transaccion.setMonto_transaccion(saldoacargar);
        //**************************
        //GUARDAMOS TRANSACCION
       /* TransaccionService tservcio = new TransaccionService();
        tservcio.saveTransaction(transaccion); SALE CON ERROR INTERFAZ NO INICIALIZADA*/
        //*********************
        this.saveTarjeta(tarjeta);
        return tarjeta;
    }
}
