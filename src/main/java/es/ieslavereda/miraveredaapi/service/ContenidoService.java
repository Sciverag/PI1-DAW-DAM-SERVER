package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el contenido.
 */
@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;
}
