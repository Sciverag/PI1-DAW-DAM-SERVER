package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Temporada {
    private int id;
    private String nombre;
    private Date changedTs;

    @Override
    public boolean equals(Object object) {
        if (object == null|| !(object instanceof Temporada)) {
            return false;
        }
        Temporada temporada = (Temporada) object;

        return id==temporada.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
