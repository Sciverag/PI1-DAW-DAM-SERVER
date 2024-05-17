package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;

import java.sql.SQLException;
import java.util.List;

public interface ICapituloRepository {
    public Contenido getCapituloById(int id) throws SQLException;
    //public Contenido getCapituloByTemporada(int id) throws SQLException;
}
