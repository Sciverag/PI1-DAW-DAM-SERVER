package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;

import java.sql.SQLException;
import java.util.List;

public interface ICapituloRepository {
    public List<Capitulo> getCapitulos() throws SQLException;
}
