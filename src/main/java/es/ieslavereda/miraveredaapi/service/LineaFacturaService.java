package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.LineaFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con la línea de factura.
 */
@Service
public class LineaFacturaService {

    @Autowired
    private LineaFacturaRepository lineaFacturaRepository;
}
