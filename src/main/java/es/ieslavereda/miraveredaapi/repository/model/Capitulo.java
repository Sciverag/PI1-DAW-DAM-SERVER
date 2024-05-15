package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

/**
 * Clase que representa un capítulo de una serie.
 * Extiende la clase Contenido e incluye información específica de un capítulo, como el ID de la serie y la temporada.
 */
@Getter
@Setter
@ToString
public class Capitulo extends Contenido {

    /**
     * El ID de la serie a la que pertenece el capítulo.
     */
    private int idSerie;

    /**
     * La temporada a la que pertenece el capítulo.
     */
    private int temporada;

    public Capitulo(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa, int idSerie, int temporada) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
        this.idSerie = idSerie;
        this.temporada = temporada;
    }
}
