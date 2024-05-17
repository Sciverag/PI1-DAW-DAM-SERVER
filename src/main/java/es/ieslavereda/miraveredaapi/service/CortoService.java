package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CortoRepository;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CortoService {

    @Autowired
    CortoRepository cortoRepository;

    public List<Contenido> getCortos() throws SQLException {
        return cortoRepository.getContenido();
    }

    public Contenido getCortoById(int id) throws SQLException {
        return cortoRepository.getContenidoById(id);
    }
}
