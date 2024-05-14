package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioRepository {

    public List<Usuario> getUsuarios() throws SQLException;
}
