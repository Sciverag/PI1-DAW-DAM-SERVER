package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.UsuarioRepository;
import es.ieslavereda.miraveredaapi.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() throws SQLException {
        return usuarioRepository.getUsuarios();
    }
}
