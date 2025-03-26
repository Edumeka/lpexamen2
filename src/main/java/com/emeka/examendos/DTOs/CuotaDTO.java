package com.emeka.examendos.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CuotaDTO {
     private int codigoCuota;

    private int mes;
    private double interes;
    private double capital;
    private double saldo;    
    private PrestamoDTO prestamo;
}
