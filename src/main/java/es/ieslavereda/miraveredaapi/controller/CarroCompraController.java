package es.ieslavereda.miraveredaapi.controller;


import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;
import es.ieslavereda.miraveredaapi.service.CarroCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


/**
 * Controlador para la gestión del carro de la compra.
 */
@RestController
@RequestMapping("/carro")
public class CarroCompraController {

    @Autowired
    private CarroCompraService carroCompraService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarroCompraById(@PathVariable("id")int id){
        try {
            return new ResponseEntity<>(carroCompraService.getCarroCompraById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @GetMapping("/&user={id}")
    public ResponseEntity<?> getCarroCompraByUsuarioId(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(carroCompraService.getCarroCompraByUsuarioId(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
