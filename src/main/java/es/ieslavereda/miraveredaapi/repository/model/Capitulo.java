package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

/**
 * Clase que representa un capítulo de una serie.
 * Extiende la clase Contenido e incluye información específica de un capítulo, como el ID de la serie y la temporada.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

}
