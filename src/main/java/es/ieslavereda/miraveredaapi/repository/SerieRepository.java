package es.ieslavereda.miraveredaapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;

public class SerieRepository implements  ISerieRepository{

    @Autowired
    @Qualifier("BBDD")
    private DataSource dataSource;
}
