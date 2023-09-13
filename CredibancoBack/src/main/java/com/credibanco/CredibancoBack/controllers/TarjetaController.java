/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.credibanco.CredibancoBack.controllers;

import com.credibanco.CredibancoBack.models.TarjetaModel;
import com.credibanco.CredibancoBack.services.TarjetaService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Fabian Castillo
 */
@RestController
@RequestMapping("/card")
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;
    @GetMapping("/all")
    public ArrayList<TarjetaModel> getTarjetas(){
        return this.tarjetaService.getTarjetas();
    }
    @GetMapping(path = "/{id}")
    public Optional<TarjetaModel> getTarjetaById(@PathVariable("id") Long id){
        return this.tarjetaService.getById(id);
    }
    //ACTIVAR O CREAR TARJETA
    @PostMapping("/enroll")
    public String saveTarjeta(@RequestBody TarjetaModel tarjeta){
        return "{ cardId: '" + this.tarjetaService.saveTarjeta(tarjeta).getNumerotarjeta() + "'}";
    }
    //BORRAR TARJETA
    @DeleteMapping(path = "/{cardid}")
    public String deleteById(@PathVariable("cardid") Long cardid){
        boolean ok = this.tarjetaService.deleteTarjeta(cardid);
        if(ok){
            return "Deleted " + cardid;
        }else{
            return "Error";
        }
    }
    @PutMapping(path = "/{id}")
    public TarjetaModel updateTarjeta(@RequestBody TarjetaModel request,@PathVariable("id") Long id){
        return this.tarjetaService.updateById(request, id);
    }
    @PostMapping(path = "/balance")
    public String updateBalance(@RequestBody TarjetaModel request){
        try{
            ArrayList<TarjetaModel> respuesta = this.tarjetaService.getBynumerotarjeta(request.getNumerotarjeta());
            String id_tarjeta = respuesta.get(0).getId_tarjeta().toString();//ID DE TARJETA DE CARDID RECIBIDO
            double balance_actual = respuesta.get(0).getSaldo();
            double balance_final = request.getSaldo() + balance_actual;

            tarjetaService.updateBalance(Long.parseLong(id_tarjeta), balance_final, request.getSaldo());
            return "Actualizado Balance Actual " + balance_final;

        }catch(Exception e){
            return "Error: " + e.toString();
        }
    }
    @GetMapping(path = "/balance/{cardid}")
    public String getBalanceCardId(@PathVariable("cardid") Long cardid){
        ArrayList<TarjetaModel> respuesta = this.tarjetaService.getBynumerotarjeta(cardid.toString());
        return "Saldo: " + this.getTarjetaById(respuesta.get(0).getId_tarjeta()).get().getSaldo();

    }
}
