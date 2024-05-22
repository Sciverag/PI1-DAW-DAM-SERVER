package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.LineaFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión de líneas de factura.
 * Este controlador maneja las solicitudes relacionadas con las líneas de factura de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lineaFactura")
public class LineaFacturaController {

    @Autowired
    private LineaFacturaService lineaFacturaService;

    @GetMapping("/&factura={id}")
    public ResponseEntity<?> getFacturasByIdFactura(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(lineaFacturaService.getLineaFacturasByIdFactura(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFacturaById(@PathVariable("id") int id){
        try {
            return new ResponseEntity(lineaFacturaService.getLineaFacturaById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/&carro={id}")
    public ResponseEntity<?> getLineaFacturasByIdCarro(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(lineaFacturaService.getLineaFacturasByIdCarro(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLineaFacturaById(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(lineaFacturaService.deleteLineafacturaById(id));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

}
