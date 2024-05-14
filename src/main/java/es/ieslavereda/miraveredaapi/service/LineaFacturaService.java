package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.LineaFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineaFacturaService {

    @Autowired
    private LineaFacturaRepository lineaFacturaRepository;
}
