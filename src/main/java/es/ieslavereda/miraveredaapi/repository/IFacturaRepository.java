package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Factura;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de factura en la base de datos.
 */
public interface IFacturaRepository {

   public List<Factura> getFacturas() throws SQLException;
   public Factura getFacturaById(int id) throws SQLException;
   public List<Factura> getFacturasByUsuarioId(int id) throws SQLException;
   public Factura addFactura(Factura factura) throws SQLException;

}
