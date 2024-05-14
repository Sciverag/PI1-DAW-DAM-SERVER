package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarroCompra {
    private int id;
    private int idUsuario;
    private Date changedTs;

    @Override
    public boolean equals(Object object) {
        if (object==null|| !(object instanceof CarroCompra)) {
            return false;
        }
        CarroCompra carroCompra = (CarroCompra) object;

        return carroCompra.getId() == id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
