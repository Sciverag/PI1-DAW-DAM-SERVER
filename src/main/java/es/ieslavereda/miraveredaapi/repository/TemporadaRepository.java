package es.ieslavereda.miraveredaapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TemporadaRepository implements ITemporadaRepository{

    @Autowired
    @Qualifier("BBDD")
    private DataSource dataSource;
}
