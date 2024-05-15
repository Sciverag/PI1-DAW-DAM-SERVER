package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con la factura.
 */
@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
}
