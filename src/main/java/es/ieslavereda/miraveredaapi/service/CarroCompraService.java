package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CarroCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el carro de compra.
 */
@Service
public class CarroCompraService {

    @Autowired
    private CarroCompraRepository carroCompraRepository;
}
