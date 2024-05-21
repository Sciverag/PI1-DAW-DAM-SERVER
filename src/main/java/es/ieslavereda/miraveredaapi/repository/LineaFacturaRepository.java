package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Factura;
import es.ieslavereda.miraveredaapi.repository.model.LineaFactura;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz ILineaFacturaRepository y proporciona acceso a los datos de línea de factura en la base de datos.
 */
@Repository
public class LineaFacturaRepository implements ILineaFacturaRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    @Override
    public List<LineaFactura> getLineaFacturasByIdFactura(int id) throws SQLException {
        String query = "SELECT * FROM LINEA_FACTURA WHERE NUM_FACTURA = ?";
        List<LineaFactura> lineaFacturas = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                lineaFacturas.add(LineaFactura.builder()
                        .id(rs.getInt(1))
                        .idCarro(rs.getInt(2))
                        .idFactura(rs.getInt(3)).build());
            }
        }
        return lineaFacturas;
    }

    @Override
    public LineaFactura getLineaFacturaById(int id) throws SQLException {
        String query = "SELECT * FROM LINEA_FACTURA WHERE ID = ?";
        LineaFactura lineaFactura = null;
        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                lineaFactura = LineaFactura.builder()
                        .id(rs.getInt(1))
                        .idCarro(rs.getInt(2))
                        .idFactura(rs.getInt(3)).build();
            }
        }
        return lineaFactura;
    }

    @Override
    public List<LineaFactura> getLineaFacturasByIdCarro(int id) throws SQLException {
        String query = "SELECT * FROM LINEA_FACTURA WHERE ID_CARRO = ?";
        List<LineaFactura> lineaFacturas = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                lineaFacturas.add(LineaFactura.builder()
                        .id(rs.getInt(1))
                        .idCarro(rs.getInt(2))
                        .idFactura(rs.getInt(3)).build());
            }
        }
        return lineaFacturas;
    }

    @Override
    public LineaFactura deleteLineaFactura(int id) throws SQLException {
        String query = "{call eliminar_linea(?)}";
        LineaFactura lineaFactura = null;
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.setInt(1, id);
            cs.executeUpdate();
            lineaFactura = getLineaFacturaById(id);
        }
        return lineaFactura;
    }
}
