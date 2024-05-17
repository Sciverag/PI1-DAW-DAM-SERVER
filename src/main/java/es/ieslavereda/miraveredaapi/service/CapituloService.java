package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CapituloRepository;
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
        return CapituloRepository.getCapitulos();
    }

    public Contenido getCapituloByid(int id) throws SQLException {
        return capituloRepository.getCapituloById(id);
    }

}
