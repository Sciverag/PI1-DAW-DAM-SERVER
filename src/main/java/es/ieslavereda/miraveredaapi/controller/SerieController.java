package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Serie;
import es.ieslavereda.miraveredaapi.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión de series.
 * Este controlador maneja las solicitudes relacionadas con las series de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping("/")
    public ResponseEntity<?> getSeries(){
        try {
            return new ResponseEntity<>(serieService.getSeries(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSerieById(@PathVariable("id")int id){
        try {
            return new ResponseEntity<>(serieService.getSerieById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSerie(@RequestBody Serie serie){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(serieService.addSerie(serie));
        }catch (SQLException e){
            return Response.response(e);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSerie(@RequestBody Serie serie){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(serieService.updateSerie(serie));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSerie(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(serieService.deleteSerie(id));
        }catch (SQLException e){
            return Response.response(e);
        }
    }

}
