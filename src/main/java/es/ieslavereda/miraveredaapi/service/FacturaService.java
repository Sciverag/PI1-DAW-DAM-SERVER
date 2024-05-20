package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.FacturaRepository;
import es.ieslavereda.miraveredaapi.repository.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con la factura.
 */
@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> getFacturas() throws SQLException{
        return facturaRepository.getFacturas();
    }

    public Factura getFacturaById(int id) throws SQLException{
        return facturaRepository.getFacturaById(id);
    }

    public List<Factura> getFacturaByUsuarioId(int id) throws SQLException{
        return facturaRepository.getFacturasByUsuarioId(id);
    }
}
