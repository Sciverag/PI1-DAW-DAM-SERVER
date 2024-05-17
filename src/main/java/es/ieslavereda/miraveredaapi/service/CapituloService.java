package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CapituloRepository;
import es.ieslavereda.miraveredaapi.repository.UsuarioRepository;
import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CapituloService {

    @Autowired
    private CapituloRepository capituloRepository;

    public List<Contenido> getCapitulos() throws SQLException {
        return capituloRepository.getContenido();
    }

    public Contenido getCapituloByid(int id) throws SQLException {
        return capituloRepository.getContenidoById(id);
    }

}
