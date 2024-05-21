package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import es.ieslavereda.miraveredaapi.repository.model.Serie;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz ISerieRepository y proporciona acceso a los datos de serie en la base de datos.
 */
@Repository
public class SerieRepository implements  ISerieRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;


    @Override
    public Serie getSerieById(int id) throws SQLException {
        String query = "SELECT * FROM SERIE WHERE ID = ?";
        Serie serie = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            serie = Serie.builder().id(rs.getInt(1))
                    .disponible_hasta(rs.getDate(2))
                    .titulo(rs.getString(3))
                    .descripcion(rs.getString(4)).url_image(rs.getString(5)).build();

        }
        return serie;
    }

    @Override
    public List<Serie> getSeries() throws SQLException {
        String query = "SELECT * FROM SERIE";
        List<Serie> series = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                series.add(Serie.builder().id(rs.getInt(1))
                        .disponible_hasta(rs.getDate(2))
                        .titulo(rs.getString(3))
                        .descripcion(rs.getString(4)).url_image(rs.getString(5)).build());
            }

        }
        return series;
    }

    @Override
    public Serie addSerie(Serie serie) throws SQLException {
        String query = "{call crear_serie(?,?,?,?)}";
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){

            cs.setString(1, serie.getTitulo());
            cs.setString(2, serie.getDescripcion());
            cs.setDate(3, serie.getDisponible_hasta());
            cs.setString(4, serie.getUrl_image());

            if (cs.executeUpdate()<1){
                serie = null;
            }
        }
        return serie;
    }
}
