package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
}
