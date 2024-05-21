package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CarroCompraRepository;
import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el carro de compra.
 */
@Service
public class CarroCompraService {

    @Autowired
    private CarroCompraRepository carroCompraRepository;

    public CarroCompra getCarroCompraById(int id) throws SQLException{
        return carroCompraRepository.getCarroCompraById(id);
    }

    public CarroCompra getCarroCompraByUsuarioId(String tag) throws SQLException{
        return carroCompraRepository.getCarroCompraByUsuarioId(tag);
    }

    public CarroCompra addLineaFactura(String tag, int id) throws SQLException{
        return carroCompraRepository.addLineaFactura(tag, id);
    }
}
