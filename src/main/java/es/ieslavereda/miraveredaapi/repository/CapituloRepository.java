package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CapituloRepository implements ICapituloRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    @Override
    public List<Capitulo> getCapitulos() throws SQLException {
        return List.of();
    }
}
