package com.emeka.examendos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emeka.examendos.DTOs.ClienteDTO;
import com.emeka.examendos.models.Cliente;
import com.emeka.examendos.models.Cuota;
import com.emeka.examendos.models.Prestamo;
import com.emeka.examendos.repositories.ClienteRepository;
import com.emeka.examendos.repositories.CuotaRepository;
import com.emeka.examendos.repositories.PrestamoRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private CuotaRepository cuotaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String crearCliente(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(clienteDTO.getDni());

        if (clienteExistente.isPresent()) {
            // Se puede enviar NULL pero yo le envio esto
            // return null
            return "El cliente con el DNI: " + clienteDTO.getDni() + " ya existe";
        }

        Cliente nuevoCliente = this.modelMapper.map(clienteDTO, Cliente.class);

        if (clienteDTO.getPrestamos() != null) {
            List<Prestamo> prestamos = new ArrayList<>();
        
            for (Prestamo prestamoDTO : nuevoCliente.getPrestamos()) {
                double cuota=0;
                Prestamo nuevoPrestamo = this.modelMapper.map(prestamoDTO, Prestamo.class);
                double interesAnual = nuevoPrestamo.getInteres();
                int n = nuevoPrestamo.getPlazo() * 12;
                
                cuota = (nuevoPrestamo.getMonto() * ((interesAnual / 12))) / (1 - (Math
                        .pow(1 + ((interesAnual / 12)), -n)));

                        nuevoPrestamo.setCuota(cuota);
                prestamos.add(nuevoPrestamo);
                this.prestamoRepository.save(nuevoPrestamo);


            
Cuota nuevaCuota = new Cuota();          
nuevaCuota.setMes(0); 
nuevaCuota.setInteres(0); 
nuevaCuota.setSaldo(nuevoPrestamo.getMonto()); 
double saldoAnterior = nuevoPrestamo.getMonto();

double capitalAnterior = nuevoPrestamo.getMonto(); 
nuevaCuota.setPrestamo(nuevoPrestamo);
cuotaRepository.save(nuevaCuota);


for (int i = 1; i <= nuevoPrestamo.getPlazo(); i++) {  
    Cuota nvCuota = new Cuota();
    
    nvCuota.setMes(i); 
    
   
    double interes = saldoAnterior * (nuevoPrestamo.getInteres() / 12);
    nvCuota.setInteres(interes);
    
   
    double capital = cuota - interes; 
    nvCuota.setCapital(capital);
    
   
    saldoAnterior -= capital; 
    
    
    nvCuota.setSaldo(saldoAnterior);
    nvCuota.setPrestamo(nuevoPrestamo);
    
    cuotaRepository.save(nvCuota);
}


             
                
            }
            nuevoCliente.setPrestamos(prestamos);
        }

        this.clienteRepository.save(nuevoCliente);

        return "Cliente creado";
    }
}
