package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de contenido en la base de datos.
 */
public interface IContenidoRepository {

    public List<Contenido> getContenidos() throws SQLException;

    public float getPrecio(int id) throws SQLException;

    public int updatePuntuacionById(int id, String tag, float punt) throws SQLException;

    public int deleteContenido(int id, String tipo) throws SQLException;
    public float anyadirPuntuacion(int id, String tag, float punt) throws SQLException;
    public Contenido getContenidoByIdLineaFactura(int id) throws SQLException;
}
