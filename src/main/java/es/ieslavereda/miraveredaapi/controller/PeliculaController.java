package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import es.ieslavereda.miraveredaapi.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
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
            return Response.response(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPeliculaById(@PathVariable("id")int id) {
        try {
            Pelicula pelicula = (Pelicula) peliculaService.getPeliculasById(id);
            if (pelicula == null){
                return new ResponseEntity<>("Pelicula no encontrada", HttpStatus.OK);
            }
            return new ResponseEntity<>(pelicula, HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPelicula(@RequestBody Pelicula pelicula){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(peliculaService.addPelicula(pelicula));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePelicula(@RequestBody Pelicula pelicula){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(peliculaService.updatePelicula(pelicula));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/alquilados/{tag}")
    public ResponseEntity<?> getPeliculasAlquilados(@PathVariable("tag")String tag){
        try {
            return new ResponseEntity<>(peliculaService.getPeliculasAlquiladas(tag), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
