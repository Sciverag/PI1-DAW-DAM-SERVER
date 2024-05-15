package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

/**
 * Clase abstracta que representa el contenido general.
 * Puede ser extendida para crear diferentes tipos de contenido, como películas o capítulos de series.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Contenido {

    /**
     * El ID del contenido.
     */
    private int id;

    /**
     * El título del contenido.
     */
    private String titulo;

    /**
     * La descripción del contenido.
     */
    private String descripcion;

    /**
     * La URL de la imagen asociada con el contenido.
     */
    private String URL_image;

    /**
     * Los actores que participan en el contenido.
     */
    private String actores;

    /**
     * La puntuación media del contenido.
     */
    private int puntMedia;

    /**
     * La fecha de estreno del contenido.
     */
    private Date fechaEstreno;

    /**
     * La duración del contenido en minutos.
     */
    private int duracion_minutos;

    /**
     * El director del contenido.
     */
    private String director;

    /**
     * El ID del género al que pertenece el contenido.
     */
    private int idGenero;

    /**
     * El ID de la tarifa asociada con el contenido.
     */
    private int idTarifa;

    /**
     * La fecha de la última modificación del contenido.
     */
    private Date changedTs;

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Contenido)) {
            return false;
        }
        Contenido contenido = (Contenido) object;

        return id == contenido.getId();
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su ID.
     */
    @Override
    public int hashCode() {
        return id;
    }

}
