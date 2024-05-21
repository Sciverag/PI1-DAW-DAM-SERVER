package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Factura;
import es.ieslavereda.miraveredaapi.repository.model.Tarifa;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de tarifa en la base de datos.
 */
public interface ITarifaRepository {

    public List<Tarifa> getTarifas() throws SQLException;
    public Tarifa getTarifaById(int id) throws SQLException;

}
