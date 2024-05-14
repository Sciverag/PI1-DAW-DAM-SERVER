package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Capitulo extends Contenido{

    private int idSerie;
    private int temporada;

}
