package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Corto;
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

@Repository
public class CortoRepository implements ICortoRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;


    @Override
    public List<Corto> getCortos() throws SQLException {
        String query = "{call obtener_cortos}";
        List<Corto> cortos = new ArrayList<Corto>();

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
}
