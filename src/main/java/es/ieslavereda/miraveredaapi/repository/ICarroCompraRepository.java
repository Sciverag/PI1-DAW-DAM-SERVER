package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Factura;
import es.ieslavereda.miraveredaapi.repository.model.LineaFactura;

import java.sql.SQLException;

/**
 * Interfaz que define los métodos para acceder a los datos del carro de compra en la base de datos.
 */
public interface ICarroCompraRepository {

    public CarroCompra getCarroCompraById(int id) throws SQLException;
    public CarroCompra getCarroCompraByUsuarioId(String tag) throws SQLException;
    public CarroCompra addLineaFactura(String tag, int id) throws SQLException;
}
