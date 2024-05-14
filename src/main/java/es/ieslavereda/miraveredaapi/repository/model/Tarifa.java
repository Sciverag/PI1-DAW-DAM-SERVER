package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Tarifa {
    private int codigo;
    private Double precio;
    private Date changedTs;

    @Override
    public boolean equals(Object object) {
        if (object==null|| !(object instanceof Tarifa)) {
            return false;
        }

        Tarifa tarifa = (Tarifa) object;
        return codigo == tarifa.getCodigo();
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
