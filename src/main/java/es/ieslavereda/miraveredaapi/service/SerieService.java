package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con la serie.
 */
@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;
}
