package es.ieslavereda.miraveredaapi.repository.model;

import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class OracleDataSourceDB {
    @Bean(name = "BBDD")
    public static OracleDataSource getOracleDataSource() throws SQLException {
        OracleDataSource oracleDS = new OracleDataSource();
        oracleDS.setURL("jdbc:oracle:thin:@172.28.201.239:1521:xe");
        oracleDS.setUser("C##1DAMSANTAMARIA");
        oracleDS.setPassword("1234");
        return oracleDS;
    }
}
