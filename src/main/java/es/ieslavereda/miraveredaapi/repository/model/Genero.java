package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Genero {
    private int id;
    private String tipo;
    private Date changedTs;

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof Genero)) {
            return false;
        }
        Genero genero = (Genero) object;

        return id == genero.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
