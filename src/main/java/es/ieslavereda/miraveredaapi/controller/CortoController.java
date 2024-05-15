package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.CortoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
