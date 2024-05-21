package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.TarifaRepository;
import es.ieslavereda.miraveredaapi.repository.model.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con la tarifa.
 */
@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    public List<Tarifa> getTarifas() throws SQLException{
        return tarifaRepository.getTarifas();
    }

    public Tarifa getTarifaById(int id) throws SQLException{
        return tarifaRepository.getTarifaById(id);
    }
}
