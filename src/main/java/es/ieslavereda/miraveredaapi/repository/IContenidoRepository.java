package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de contenido en la base de datos.
 */
public interface IContenidoRepository {

    public List<Contenido> getContenidos() throws SQLException;
    public List<Contenido> getContenidosByTag() throws SQLException;
}
