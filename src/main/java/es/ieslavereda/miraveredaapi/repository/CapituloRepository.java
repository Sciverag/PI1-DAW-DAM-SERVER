package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CapituloRepository implements ICapituloRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    public static List<Capitulo> getCapitulos() throws SQLException {
        OracleDataSource dataSource = OracleDataSourceDB.getOracleDataSource();

        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "cap.TEMPORADA, cap.ID_SERIE FROM CONTENIDO c " +
                "JOIN CAPITULO cap ON c.ID = cap.ID_CONT";

        List<Capitulo> capitulos = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery(query);
            rs.next();

            capitulos.add(new Capitulo(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getFloat(6),
                    rs.getDate(7),
                    rs.getFloat(8),
                    rs.getString(9),
                    rs.getInt(10),
                    rs.getInt(11),
                    rs.getInt(12),
                    rs.getInt(13)));
        }
        return capitulos;
    }

    @Override
    public Capitulo getCapituloById(int id) throws SQLException {
        String query = "SELECT c.ID AS ID_CONTENIDO, c.TITULO, " +
                "c.DESCRIPCION, c.URL_IMAGEN, c.ACTORES, c.PUNT_MEDIA, " +
                "c.FECH_ESTRENO, c.DURACION, c.DIRECTOR, c.ID_GENERO, " +
                "c.ID_TARIFA, cap.TEMPORADA, cap.ID_SERIE FROM CONTENIDO c " +
                "JOIN CAPITULO cap ON c.ID = cap.ID_CONT WHERE cap.ID_CONT = ?";
        Capitulo capitulo = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                capitulo = new Capitulo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12),
                        rs.getInt(13));
            }

        }
        return capitulo;
    }

    @Override
    public Capitulo addCapitulo(Capitulo capitulo) throws SQLException {
        String query = "{call crear_capitulo(?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){

/*            if (getCapituloById(capitulo.getId()) != null){
                return null;
            }*/

            cs.setString(1, capitulo.getTitulo());
            cs.setString(2, capitulo.getDescripcion());
            cs.setString(3, capitulo.getURL_image());
            cs.setString(4, capitulo.getActores());
            cs.setFloat(5, capitulo.getPuntMedia());
            cs.setDate(6, capitulo.getFechaEstreno());
            cs.setFloat(7, capitulo.getDuracion_minutos());
            cs.setString(8, capitulo.getDirector());
            cs.setInt(9, capitulo.getIdGenero());
            cs.setInt(10, capitulo.getIdTarifa());
            cs.setInt(11, capitulo.getTemporada());
            cs.setInt(12, capitulo.getIdSerie());

            cs.execute();
        }
        return capitulo;
    }
}
