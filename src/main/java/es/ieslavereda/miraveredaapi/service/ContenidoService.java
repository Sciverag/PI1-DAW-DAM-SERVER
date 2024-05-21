package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.ContenidoRepository;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el contenido.
 */
@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> getContenido() throws SQLException{
        return contenidoRepository.getContenidos();
    }

    public Double getPrecio(int id) throws SQLException{
        return contenidoRepository.getPrecio(id);
    }

    public int updatePuntuacionById(int id, int punt) throws  SQLException{
        return contenidoRepository.updatePuntuacionById(id, punt);
    }

    public int deleteContenido(Contenido contenido) throws SQLException{
        return contenidoRepository.deleteContenido(contenido);
    }
}
