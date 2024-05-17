package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;

import java.sql.SQLException;
import java.util.List;

public interface ICapituloRepository {
    public List<Contenido> getContenido() throws SQLException;
    public Contenido getContenidoById(int id) throws SQLException;
}
