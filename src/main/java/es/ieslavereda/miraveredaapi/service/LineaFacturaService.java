package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.LineaFacturaRepository;
import es.ieslavereda.miraveredaapi.repository.model.LineaFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con la línea de factura.
 */
@Service
public class LineaFacturaService {

    @Autowired
    private LineaFacturaRepository lineaFacturaRepository;

    public List<LineaFactura> getLineaFacturasByIdFactura(int id) throws SQLException{
        return lineaFacturaRepository.getLineaFacturasByIdFactura(id);
    }

    public LineaFactura getLineaFacturaById(int id) throws SQLException{
        return lineaFacturaRepository.getLineaFacturaById(id);
    }

    public List<LineaFactura> getLineaFacturasByIdCarro(int id) throws SQLException{
        return lineaFacturaRepository.getLineaFacturasByIdCarro(id);
    }

    public LineaFactura deleteLineafacturaById(int id) throws SQLException{
        return lineaFacturaRepository.deleteLineaFactura(id);
    }
}
