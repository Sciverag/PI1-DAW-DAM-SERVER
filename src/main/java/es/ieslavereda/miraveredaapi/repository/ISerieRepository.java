package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Serie;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de serie en la base de datos.
 */
public interface ISerieRepository {

    public Serie getSerieById(int id) throws SQLException;
    public List<Serie> getSeries() throws SQLException;
    public Serie addSerie(Serie serie) throws SQLException;

}
