package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

}
