package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Serie {

    private int id;
    private Date disponible_hasta;
    private String titulo;
    private String descripcion;

    @Override
    public boolean equals(Object object) {
        if (object == null|| !(object instanceof Serie)) {
            return false;
        }
        Serie serie = (Serie) object;

        return id == serie.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
