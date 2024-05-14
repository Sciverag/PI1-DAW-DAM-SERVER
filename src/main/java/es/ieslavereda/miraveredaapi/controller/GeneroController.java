package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;
}
