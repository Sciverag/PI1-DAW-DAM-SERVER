package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;

import java.sql.SQLException;
import java.util.List;

public interface IPeliculaRepository {
    public List<Contenido> getContenido() throws SQLException;
    public Contenido getContenidoById(int id) throws SQLException;
}
