package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


/**
 * Controlador para la gestión del contenido.
 * Este controlador maneja las solicitudes relacionadas con el contenido de la aplicación.
 */
@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping("/")
    public ResponseEntity<?> getContenido() {
        try {
            return new ResponseEntity<>(contenidoService.getContenido(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/precio/{id}")
    public ResponseEntity<?> getPrecio(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(contenidoService.getPrecio(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
