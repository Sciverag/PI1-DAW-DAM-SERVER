package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private SerieService serieService;
}
