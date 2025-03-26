package com.emeka.examendos.DTOs;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
     private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private List<PrestamoDTO> prestamos;
}
