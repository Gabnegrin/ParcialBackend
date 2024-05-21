package parcial.demo.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class libroDTO {
    private long id;
    private String nombre;
    private String autor;
    private LocalDate fe_escritura;
    private String edicion;
    private int precio;
    private boolean tipo;
    private boolean eliminado;
    private int fama;
}
