package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CapituloRepository;
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

    public List<Capitulo> getCapitulos() throws SQLException {
        return CapituloRepository.getCapitulos();
    }

    public Capitulo getCapituloByid(int id) throws SQLException {
        return capituloRepository.getCapituloById(id);
    }

    public Capitulo addCapitulo(Capitulo capitulo) throws SQLException{
        return capituloRepository.addCapitulo(capitulo);
    }

    public List<Capitulo> getCapitulosBySerie(int id) throws SQLException{
        return capituloRepository.getCapitulosBySerie(id);
    }

}
