package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.service.CortoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/contenido/corto")
public class CortoController {

    @Autowired
    CortoService cortoService;

    @GetMapping("/")
    public ResponseEntity<?> getCortos(){
        try {
            return new ResponseEntity<>(cortoService.getCortos(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCortoById(@PathVariable("id") int id){
        try {
            Corto corto = (Corto)cortoService.getCortoById(id);
            if (corto==null){
                return new ResponseEntity<>("Corto no encontrado", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(corto, HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

}
