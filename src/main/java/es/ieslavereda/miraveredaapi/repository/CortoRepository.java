package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CortoRepository implements ICortoRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;


    public static List<Contenido> getCortos() throws SQLException {
        OracleDataSource dataSource = OracleDataSourceDB.getOracleDataSource();

        String query = "SELECT c.ID AS ID_CONTENIDO, c.TITULO, c.DESCRIPCION, " +
                "c.URL_IMAGEN, c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA FROM CONTENIDO c " +
                "JOIN CORTO co ON c.ID = co.ID_CONT";

        List<Contenido> cortos = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                cortos.add(new Corto(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        }
        return cortos;
    }

    @Override
    public Contenido getCortoById(int id) throws SQLException {
        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "corto.ID_CONT FROM CONTENIDO c " +
                "JOIN CORTO corto ON c.ID = corto.ID_CONT WHERE corto.ID_CONT = ?";
        Contenido corto = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                corto = new Corto(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11));

            }

        }
        return corto;
    }


}
