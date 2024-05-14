package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Contenido {

    private int id;
    private String titulo;
    private String descripcion;
    private String URL_image;
    private String actores;
    private int puntMedia;
    private Date fechaEstreno;
    private int duracion_minutos;
    private String director;
    private int idGenero;
    private int idTarifa;
    private Date changedTs;

    @Override
    public boolean equals(Object object) {
        if (object==null|| !(object instanceof Contenido)) {
            return false;
        }
        Contenido contenido = (Contenido) object;

        return id == contenido.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

}
