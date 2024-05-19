package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;

import java.sql.SQLException;
import java.util.List;

public interface IPeliculaRepository {
    public Pelicula getPeliculaById(int id) throws SQLException;
    public Pelicula addPelicula(Pelicula pelicula) throws SQLException;
}
