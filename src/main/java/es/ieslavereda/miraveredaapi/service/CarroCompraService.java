package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CarroCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroCompraService {

    @Autowired
    private CarroCompraRepository carroCompraRepository;
}
