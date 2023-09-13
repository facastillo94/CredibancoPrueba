/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.credibanco.CredibancoBack.repositories;

import com.credibanco.CredibancoBack.models.TarjetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 *
 * @author Fabian Castillo
 */
@Repository
public interface ITarjetaRepository extends JpaRepository<TarjetaModel, Long> {
    ArrayList<TarjetaModel> findBynumerotarjeta(String numerotarjeta);
}
