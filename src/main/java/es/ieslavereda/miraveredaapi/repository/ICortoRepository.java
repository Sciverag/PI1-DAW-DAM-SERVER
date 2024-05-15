package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Corto;

import java.sql.SQLException;
import java.util.List;

public interface ICortoRepository {
    public List<Corto> getCortos() throws SQLException;
}
