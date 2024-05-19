package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;

import java.sql.SQLException;

/**
 * Interfaz que define los métodos para acceder a los datos del carro de compra en la base de datos.
 */
public interface ICarroCompraRepository {

    public CarroCompra getCarroCompraById(int id) throws SQLException;
    public CarroCompra getCarroCompraByUsuarioId(int id) throws SQLException;
}
