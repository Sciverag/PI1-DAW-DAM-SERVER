package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

/**
 * Clase que representa una película.
 * Extiende la clase Contenido e incluye información específica de una película, como la fecha hasta la cual está disponible.
 */
@Getter
@Setter
@ToString
public class Pelicula extends Contenido {

    /**
     * La fecha hasta la cual la película está disponible.
     */
    private Date disponible_hasta;

    public Pelicula(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa, Date disponible_hasta) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
//        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
        this.disponible_hasta = disponible_hasta;
    }
}


