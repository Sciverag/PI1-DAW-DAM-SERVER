package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/contenido/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/")
    public ResponseEntity<?> getPeliculas(){
        try {
            return new ResponseEntity<>(peliculaService.getPeliculas(), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
