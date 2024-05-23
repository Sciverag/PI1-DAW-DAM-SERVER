package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Factura;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;

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
                    .idUsuario(rs.getString(3)).build();

        }
        return carroCompra;
    }

    @Override
    public CarroCompra getCarroCompraByUsuarioId(String tag) throws SQLException {
        String query = "SELECT * FROM CARRO_COMPRA WHERE ID_USUARIO = ?";
        CarroCompra carroCompra = null;

        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, tag);

            ResultSet rs = ps.executeQuery();
            rs.next();
            carroCompra = CarroCompra.builder().id(rs.getInt(1))
                    .idUsuario(rs.getString(3)).build();


        }
        return carroCompra;
    }

    @Override
    public CarroCompra addLineaFactura(String tag, int id) throws SQLException {
        String query = "{call agregar_articulo_carrito(?,?)}";
        CarroCompra carroCompra = null;
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tag);
            cs.setInt(2, id);


            if (cs.executeUpdate()>0) {
                carroCompra = getCarroCompraByUsuarioId(tag);
            }
        }
        return carroCompra;
    }




}
