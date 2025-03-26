package com.emeka.examendos.DTOs;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDTO {
     private int codigoPrestamo;
    private LocalDate fechaApertura;
    private double monto;
    private double cuota;
    private int plazo;
    private double interes;
    private ClienteDTO cliente;
}
