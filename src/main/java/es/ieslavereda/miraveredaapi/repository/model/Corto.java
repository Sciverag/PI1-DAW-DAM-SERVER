package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
public class Corto extends Contenido{

    public Corto(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
    }
}
