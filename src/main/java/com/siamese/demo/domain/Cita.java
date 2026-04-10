package com.siamese.demo.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
public class Cita {
    Long id;
    LocalDate fecha;
    String nombre;
    String razon;
    LocalTime hora;
    
    public Cita(){
        
    }

    public Cita(Long id, LocalDate fecha, String nombre, String razon, LocalTime hora) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.razon = razon;
        this.hora = hora;
    }
}
