package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<?> getUsuarios(){
        try {
            return new ResponseEntity<>(usuarioService.getUsuarios(), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
