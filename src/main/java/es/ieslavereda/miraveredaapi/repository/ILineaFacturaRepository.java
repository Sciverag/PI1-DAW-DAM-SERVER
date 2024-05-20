package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.LineaFactura;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de línea de factura en la base de datos.
 */
public interface ILineaFacturaRepository {

    public List<LineaFactura> getLineaFacturasByIdFactura(int id) throws SQLException;
    public LineaFactura getLineaFacturaById(int id) throws SQLException;
    public List<LineaFactura> getLineaFacturasByIdCarro(int id) throws SQLException;
}
