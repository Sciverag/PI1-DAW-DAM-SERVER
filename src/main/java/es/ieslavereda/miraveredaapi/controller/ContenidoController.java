package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión del contenido.
 * Este controlador maneja las solicitudes relacionadas con el contenido de la aplicación.
 */
@CrossOrigin(origins = "*")
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

    @PutMapping("/update/puntuacion/&id={id}&punt={punt}&user={tag}")
    public ResponseEntity<?> updatePuntuacionById(@PathVariable("id") int id, @PathVariable("punt") float punt, @PathVariable("tag")String tag){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(contenidoService.updatePuntuacionById(id, tag, punt));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @DeleteMapping("/delete/&id={id}&tipo={tipo}")
    public ResponseEntity<?> deleteContenido(@PathVariable("id")int id, @PathVariable("tipo")String tipo){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(contenidoService.deleteContenido(id, tipo));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @PostMapping("/add/puntacion/&id={id}&user={tag}&punt={punt}")
    public ResponseEntity<?> anyadirPuntuacion(@PathVariable("id")int id, @PathVariable("tag")String tag, @PathVariable("punt")float punt){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(contenidoService.anyadirPuntuacion(id,tag,punt));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/lineaFactura/{id}")
    public ResponseEntity<?> getContenidoByIdLinea(@PathVariable("id") int id){
        try{
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(contenidoService.getContenidoByIdLinea(id));
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
