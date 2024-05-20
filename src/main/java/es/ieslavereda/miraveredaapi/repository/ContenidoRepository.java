package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.*;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que proporciona acceso a los datos de contenido en la base de datos.
 */
@Repository
public class ContenidoRepository implements IContenidoRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    @Override
    public List<Contenido> getContenidos() throws SQLException {
        List<Contenido> contenidos = new ArrayList<>();

        contenidos.addAll(CapituloRepository.getCapitulos());
        contenidos.addAll(PeliculaRepository.getPeliculas());
        contenidos.addAll(CortoRepository.getCortos());

        return contenidos;
    }

    @Override
    public Double getPrecio(int id) throws SQLException {
        String query = "SELECT TARIFA.PRECIO AS PRECIO_TARIFA " +
                "FROM CONTENIDO JOIN TARIFA ON CONTENIDO.ID_TARIFA = TARIFA.ID " +
                "WHERE CONTENIDO.ID = ?";
        Double precio = 0.0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            precio = rs.getDouble(1);

        }
        return precio;
    }


}
