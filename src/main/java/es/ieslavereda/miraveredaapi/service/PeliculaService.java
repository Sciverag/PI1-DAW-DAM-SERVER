package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.PeliculaRepository;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Contenido> getPeliculas() throws SQLException{
        return peliculaRepository.getContenido();
    }

    public Contenido getPeliculasById(int id) throws SQLException{
        return peliculaRepository.getContenidoById(id);
    }
}
