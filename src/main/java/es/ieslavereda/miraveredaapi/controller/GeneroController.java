package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


/**
 * Controlador para la gestión de géneros.
 * Este controlador maneja las solicitudes relacionadas con los géneros de la aplicación.
 */
@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/")
    public ResponseEntity<?> getGeneros(){
        try {
            return new ResponseEntity<>(generoService.getGeneros(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<?> getGeneroById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(generoService.getGeneroById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
