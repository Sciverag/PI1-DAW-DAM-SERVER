package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String query = "select * from CONTENIDO";
        List<Contenido> contenidos = new ArrayList<Contenido>();

        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()){

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                contenidos.add(new Corto(rs.getInt(1),
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
        return contenidos;
    }

    @Override
    public List<Contenido> getContenidosByTag() throws SQLException {
        return null;
    }


}
