package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Factura;
import es.ieslavereda.miraveredaapi.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión de facturas.
 * Este controlador maneja las solicitudes relacionadas con las facturas de la aplicación.
 */
@CrossOrigin
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
    public ResponseEntity<?> getFacturasByUsuarioId(@PathVariable("id")String id){
        try {
            return new ResponseEntity<>(facturaService.getFacturaByUsuarioId(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFactura(@RequestBody Factura factura){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(facturaService.addFactura(factura));
        }catch (SQLException e){
            return Response.response(e);
        }
    }

    @PutMapping("/finalizar/{tag}")
    public ResponseEntity<?> finalizarPedido(@PathVariable("tag")String tag){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(facturaService.finalizarPedido(tag));
        } catch (SQLException e){
            return Response.response(e);
        }
    }


}
