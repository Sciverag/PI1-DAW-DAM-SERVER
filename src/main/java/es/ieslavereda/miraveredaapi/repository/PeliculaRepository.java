package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import oracle.jdbc.datasource.impl.OracleDataSource;
import oracle.jdbc.proxy.annotation.Pre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PeliculaRepository implements IPeliculaRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    public static List<Pelicula> getPeliculas() throws SQLException{
        OracleDataSource dataSource = OracleDataSourceDB.getOracleDataSource();

        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "p.DISPONIBLE_HASTA FROM CONTENIDO c JOIN PELICULA p ON c.ID = p.ID_CONT";

        List<Pelicula> peliculas = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){

            ResultSet rs = cs.executeQuery();

            while (rs.next()){
                peliculas.add(new Pelicula(rs.getInt(1),
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
                        rs.getDate(12)));
            }

        }
        return peliculas;
    }

    @Override
    public Pelicula getPeliculaById(int id) throws SQLException {
        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "p.DISPONIBLE_HASTA FROM CONTENIDO c " +
                "JOIN PELICULA p ON c.ID = p.ID_CONT WHERE p.ID_CONT = ?";

        Pelicula pelicula = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                pelicula = new Pelicula(rs.getInt(1),
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
                        rs.getDate(12));
            }
        }
        return pelicula;
    }

    @Override
    public Pelicula addPelicula(Pelicula pelicula) throws SQLException {
        String query = "{call crear_pelicula(?,?,?,?,?,?,?,?,?,?,?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){

            if (getPeliculaById(pelicula.getId())!=null){
                return null;
            }

            cs.setString(1, pelicula.getTitulo());
            cs.setString(2, pelicula.getURL_image());
            cs.setString(3, pelicula.getActores());
            cs.setFloat(4, pelicula.getPuntMedia());
            cs.setDate(5, pelicula.getFechaEstreno());
            cs.setFloat(6, pelicula.getDuracion_minutos());
            cs.setString(7, pelicula.getDirector());
            cs.setInt(8, pelicula.getIdGenero());
            cs.setInt(9, pelicula.getIdTarifa());
            cs.setDate(10, pelicula.getDisponible_hasta());

            if (cs.executeUpdate()<1){
                pelicula = null;
            }
        }
        return pelicula;
    }

}
