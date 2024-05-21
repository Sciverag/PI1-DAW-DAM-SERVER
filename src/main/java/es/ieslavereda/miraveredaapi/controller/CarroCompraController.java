package es.ieslavereda.miraveredaapi.controller;


import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;
import es.ieslavereda.miraveredaapi.service.CarroCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión del carro de la compra.
 */
@CrossOrigin
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

    @GetMapping("/&user={tag}")
    public ResponseEntity<?> getCarroCompraByUsuarioId(@PathVariable("tag") String tag){
        try {
            return new ResponseEntity<>(carroCompraService.getCarroCompraByUsuarioId(tag), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    @PostMapping("/addLinea/&user={tag}&idCont={id}")
    public ResponseEntity<?> addLineaFactura(@PathVariable("tag") String tag, @PathVariable("id")int id){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(carroCompraService.addLineaFactura(tag,id));
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
