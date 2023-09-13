package com.credibanco.CredibancoBack.controllers;

import com.credibanco.CredibancoBack.models.TarjetaModel;
import com.credibanco.CredibancoBack.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;


}
