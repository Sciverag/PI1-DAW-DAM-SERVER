package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;

import java.sql.SQLException;
import java.util.List;

public interface ICortoRepository {
    public Corto getCortoById(int id) throws SQLException;
    public Corto addCorto(Corto corto) throws SQLException;
    public int updateCorto(Corto corto) throws SQLException;
    public List<Corto> getCortosAlquilados(String tag) throws SQLException;
}
