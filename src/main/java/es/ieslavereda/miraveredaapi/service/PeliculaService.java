package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.PeliculaRepository;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Pelicula> getPeliculas() throws SQLException{
        return peliculaRepository.getPeliculas();
    }
}
