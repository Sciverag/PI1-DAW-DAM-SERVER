package es.ieslavereda.miraveredaapi.repository.model;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Factura {

    private int numero;
    private Date fecha;
    private Double importe_base;
    private Double importe_IVA;
    private int idUsuario;
    private Date changedTs;

    @Override
    public boolean equals(Object object) {
        if (object==null || !(object instanceof Factura)) {
            return false;
        }

        Factura factura = (Factura) object;

        return numero==factura.getNumero();
    }

    @Override
    public int hashCode() {
        return numero;
    }


}
