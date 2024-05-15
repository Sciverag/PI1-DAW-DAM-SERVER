package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Pelicula;

import java.sql.SQLException;
import java.util.List;

public interface IPeliculaRepository {
    public List<Pelicula> getPeliculas() throws SQLException;
}
