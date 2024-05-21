package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.StringReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CortoRepository implements ICortoRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;


    public static List<Corto> getCortos() throws SQLException {
        OracleDataSource dataSource = OracleDataSourceDB.getOracleDataSource();

        String query = "SELECT c.ID AS ID_CONTENIDO, c.TITULO, c.DESCRIPCION, " +
                "c.URL_IMAGEN, c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA FROM CONTENIDO c " +
                "JOIN CORTO co ON c.ID = co.ID_CONT";

        List<Corto> cortos = new ArrayList<>();

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
    public Corto getCortoById(int id) throws SQLException {
        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "corto.ID_CONT FROM CONTENIDO c " +
                "JOIN CORTO corto ON c.ID = corto.ID_CONT WHERE corto.ID_CONT = ?";
        Corto corto = null;

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

    @Override
    public Corto addCorto(Corto corto) throws SQLException{
        String query = "{call crear_corto(?,?,?,?,?,?,?,?,?,?)}";

        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){

            cs.setString(1, corto.getTitulo());
            cs.setString(2, corto.getDescripcion());
            cs.setString(3, corto.getURL_image());
            cs.setString(4, corto.getActores());
            cs.setFloat(5, corto.getPuntMedia());
            cs.setDate(6, corto.getFechaEstreno());
            cs.setFloat(7, corto.getDuracion_minutos());
            cs.setString(8, corto.getDirector());
            cs.setInt(9, corto.getIdGenero());
            cs.setInt(10, corto.getIdTarifa());

            if (cs.executeUpdate() < 1){
                corto = null;
            }

        }
        return corto;
    }

    @Override
    public int updateCorto(Corto corto) throws SQLException {
        String query = "{?= call actualizar_corto(?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, corto.getId());
            cs.setString(3, corto.getTitulo());
            cs.setString(4, corto.getDescripcion());
            cs.setString(5, corto.getURL_image());
            cs.setString(6, corto.getActores());
            cs.setFloat(7, corto.getPuntMedia());
            cs.setDate(8 ,corto.getFechaEstreno());
            cs.setFloat(9, corto.getDuracion_minutos());
            cs.setString(10, corto.getDirector());
            cs.setInt(11, corto.getIdGenero());
            cs.setInt(12, corto.getIdTarifa());

            resultado = cs.executeUpdate();
        }
        return resultado;
    }


}
