package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Controlador para la gestión de usuarios.
 * Este controlador maneja las solicitudes relacionadas con los usuarios de la aplicación.
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; // Servicio para la gestión de usuarios

    /**
     * Obtiene la lista de usuarios.
     * @return Una ResponseEntity que contiene la lista de usuarios si la operación es exitosa, o un código de error si ocurre una excepción SQL.
     */
    @GetMapping("/")
    public ResponseEntity<?> getUsuarios(){
        try {
            return new ResponseEntity<>(usuarioService.getUsuarios(), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
