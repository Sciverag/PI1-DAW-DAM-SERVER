package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que implementa la interfaz ICarroCompraRepository y proporciona acceso a los datos del carro de compra en la base de datos.
 */
@Repository
public class CarroCompraRepository implements ICarroCompraRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    @Override
    public CarroCompra getCarroCompraById(int id) throws SQLException {
        String query = "SELECT * FROM CARRO_COMPRA WHERE ID = ?";
        CarroCompra carroCompra = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            carroCompra = CarroCompra.builder().id(rs.getInt(1))
                    .idUsuario(rs.getInt(2)).build();

        }
        return carroCompra;
    }

    @Override
    public CarroCompra getCarroCompraByUsuarioId(int id) throws SQLException {
        String query = "SELECT * FROM CARRO_COMPRA WHERE ID_USUARIO = ?";
        CarroCompra carroCompra = null;

        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            carroCompra = CarroCompra.builder().id(rs.getInt(1))
                    .idUsuario(rs.getInt(2)).build();


        }
        return carroCompra;
    }

}
