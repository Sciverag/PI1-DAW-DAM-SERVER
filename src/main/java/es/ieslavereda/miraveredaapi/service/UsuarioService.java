package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.UsuarioRepository;
import es.ieslavereda.miraveredaapi.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el usuario.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtiene la lista de usuarios.
     * @return La lista de usuarios.
     * @throws SQLException Si ocurre un error al obtener la lista de usuarios.
     */
    public List<Usuario> getUsuarios() throws SQLException {
        return usuarioRepository.getUsuarios();
    }

    public int deleteUsuario(String tag) throws SQLException {
        return usuarioRepository.deleteUsuario(tag);
    }

    public int actualizarUsuario(Usuario usuario) throws SQLException{
        return usuarioRepository.actualizarUsuario(usuario);
    }
}
