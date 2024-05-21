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

    public List<Corto> getCortos() throws SQLException {
        return CortoRepository.getCortos();
    }

    public Corto getCortoById(int id) throws SQLException {
        return cortoRepository.getCortoById(id);
    }

    public Corto addCorto(Corto corto) throws SQLException {
        return cortoRepository.addCorto(corto);
    }

    public int updateCorto(Corto corto) throws SQLException{
        return cortoRepository.updateCorto(corto);
    }
}
