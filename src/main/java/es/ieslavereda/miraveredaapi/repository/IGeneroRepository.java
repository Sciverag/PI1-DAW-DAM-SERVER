package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Genero;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de género en la base de datos.
 */
public interface IGeneroRepository {

    public List<Genero> getGeneros() throws SQLException;
    public Genero getGeneroById(int id) throws SQLException;
}
