package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PeliculaRepository implements IPeliculaRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    public List<Pelicula> getPeliculas() throws SQLException{
        String query = "{call obtener_peliculas}";
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

}
