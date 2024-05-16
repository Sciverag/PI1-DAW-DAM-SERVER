package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.service.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/contenido/capitulo")
public class CapituloController {

    @Autowired
    private CapituloService capituloService;

    @GetMapping("/")
    public ResponseEntity<?> getCapitulos() {
        try {
            return new ResponseEntity<>(capituloService.getCapitulos(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPeliculaById(@PathVariable("id") int id){
        try {
            Capitulo capitulo = (Capitulo) capituloService.getCapituloByid(id);
            if (capitulo==null){
                return new ResponseEntity<>("Capitulo no encontrado", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(capitulo, HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

}
