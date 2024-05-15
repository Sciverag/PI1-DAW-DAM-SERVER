package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

/**
 * Clase que representa una película.
 * Extiende la clase Contenido e incluye información específica de una película, como la fecha hasta la cual está disponible.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Pelicula extends Contenido {

    /**
     * La fecha hasta la cual la película está disponible.
     */
    private Date disponible_hasta;

}
