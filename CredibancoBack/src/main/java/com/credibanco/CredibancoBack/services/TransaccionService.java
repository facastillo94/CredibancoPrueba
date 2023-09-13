package com.credibanco.CredibancoBack.services;

import com.credibanco.CredibancoBack.models.TransaccionModel;
import com.credibanco.CredibancoBack.repositories.ITarjetaRepository;
import com.credibanco.CredibancoBack.repositories.ITransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    @Autowired
    ITransaccionRepository transaccionRepository;

    public TransaccionModel saveTransaction(TransaccionModel transaccion){return  transaccionRepository.save(transaccion);}
}
