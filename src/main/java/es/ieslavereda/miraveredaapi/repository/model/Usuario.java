package es.ieslavereda.miraveredaapi.repository.model;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenya;
    private String domicilio;
    private int CP;
    private Date fechaNacimiento;
    private int num_tarjeta;
    private Date changedTs;

    @Override
    public boolean equals(Object object){
        if (object == null || !(object instanceof Usuario)){
            return false;
        }

        Usuario usuario = (Usuario) object;

        return id==usuario.getId();
    }

    @Override
    public int hashCode(){
        return id;
    }

}
