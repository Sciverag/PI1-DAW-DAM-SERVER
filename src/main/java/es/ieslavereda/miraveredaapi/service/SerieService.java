package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.SerieRepository;
import es.ieslavereda.miraveredaapi.repository.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con la serie.
 */
@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> getSeries() throws SQLException{
        return serieRepository.getSeries();
    }

    public Serie getSerieById(int id) throws SQLException{
        return serieRepository.getSerieById(id);
    }

    public Serie addSerie(Serie serie) throws SQLException{
        return serieRepository.addSerie(serie);
    }

    public int updateSerie(Serie serie) throws SQLException{
        return serieRepository.updateSerie(serie);
    }

    public int deleteSerie(int id) throws SQLException{
        return serieRepository.deleteSerie(id);
    }
}
