package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador para la gestión de facturas.
 * Este controlador maneja las solicitudes relacionadas con las facturas de la aplicación.
 */
@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;
}
