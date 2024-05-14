package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LineaFactura {

    private int id;
    private int idCarro;
    private int idFactura;
    private Date changedTs;

    @Override
    public boolean equals(Object object) {
        if (object==null|| !(object instanceof LineaFactura)) {
            return false;
        }

        LineaFactura lineaFactura =  (LineaFactura) object;

        return id == lineaFactura.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
