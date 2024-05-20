package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


/**
 * Controlador para la gestión de facturas.
 * Este controlador maneja las solicitudes relacionadas con las facturas de la aplicación.
 */
@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/")
    public ResponseEntity<?> getFacturas(){
        try {
            return new ResponseEntity<>(facturaService.getFacturas(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFacturaById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(facturaService.getFacturaById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/&user={id}")
    public ResponseEntity<?> getFacturasByUsuarioId(@PathVariable("id")int id){
        try {
            return new ResponseEntity<>(facturaService.getFacturaByUsuarioId(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
