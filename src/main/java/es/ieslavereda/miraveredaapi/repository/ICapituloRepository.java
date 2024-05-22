package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;

import java.sql.SQLException;
import java.util.List;

public interface ICapituloRepository {
    public Contenido getCapituloById(int id) throws SQLException;
    public List<Capitulo> getCapitulosBySerie(int id) throws SQLException;
    public Capitulo addCapitulo(Capitulo capitulo) throws SQLException;
    public int updateCapitulo(Capitulo capitulo) throws SQLException;
    public List<Capitulo> getCapitulosAlquilados(String tag) throws SQLException;
}
