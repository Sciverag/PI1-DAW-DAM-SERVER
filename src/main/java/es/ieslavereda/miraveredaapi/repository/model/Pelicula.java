package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Pelicula extends Contenido{

    private Date disponible_hasta;

}
