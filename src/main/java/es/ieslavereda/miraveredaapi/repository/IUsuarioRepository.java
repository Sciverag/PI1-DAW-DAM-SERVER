package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de usuario en la base de datos.
 */
public interface IUsuarioRepository {

    /**
     * Obtiene la lista de usuarios.
     * @return La lista de usuarios.
     * @throws SQLException Si ocurre un error al obtener la lista de usuarios.
     */
    public List<Usuario> getUsuarios() throws SQLException;

    public int deleteUsuario(String tag) throws SQLException;

    public int actualizarUsuario(Usuario usuario) throws SQLException;

    public Usuario getUsuarioByTag(String tag) throws SQLException;

    public Usuario authenticateUsuario(String login, String password) throws SQLException;
}
