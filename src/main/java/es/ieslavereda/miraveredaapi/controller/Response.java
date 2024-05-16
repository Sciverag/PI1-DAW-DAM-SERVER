package es.ieslavereda.miraveredaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Response {
    public static ResponseEntity<?> response(SQLException e){
        Map<String,Object> response = new HashMap<>();
        response.put("code", e.getErrorCode());
        response.put("message",e.getMessage());
        response.put("sqlstate",e.getSQLState());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
