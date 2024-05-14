package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;
}
