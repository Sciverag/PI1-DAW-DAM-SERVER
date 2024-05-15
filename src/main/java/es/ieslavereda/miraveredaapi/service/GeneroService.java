package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el género.
 */
@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;
}
