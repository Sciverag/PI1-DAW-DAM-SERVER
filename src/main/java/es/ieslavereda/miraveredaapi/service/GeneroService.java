package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.GeneroRepository;
import es.ieslavereda.miraveredaapi.repository.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el género.
 */
@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getGeneros() throws SQLException{
        return generoRepository.getGeneros();
    }

    public Genero getGeneroById(int id) throws SQLException{
        return generoRepository.getGeneroById(id);
    }
}
