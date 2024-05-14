package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;
}
