package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;
}
