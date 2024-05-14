package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.LineaFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador para la gestión de líneas de factura.
 * Este controlador maneja las solicitudes relacionadas con las líneas de factura de la aplicación.
 */
@RestController
@RequestMapping("/lineaFactura")
public class LineaFacturaController {

    @Autowired
    private LineaFacturaService lineaFacturaService;

}
