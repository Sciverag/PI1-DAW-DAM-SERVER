package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.service.CortoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin
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

    @PostMapping("/add")
    public ResponseEntity<?> addCorto(@RequestBody Corto corto){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(cortoService.addCorto(corto));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCorto(@RequestBody Corto corto){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(cortoService.updateCorto(corto));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

}
