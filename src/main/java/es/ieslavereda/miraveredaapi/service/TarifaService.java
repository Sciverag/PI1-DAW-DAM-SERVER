package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;
}
