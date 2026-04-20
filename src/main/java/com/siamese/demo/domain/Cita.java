package com.siamese.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
@Entity
@Table(name = "cita")
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id;
    
    @Column (name = "dueño_mascota")
    private String dueño;
    
    @Column(name= "nombre_mascota")
    private String nombreMascota;
    
    private String raza;
    
    private LocalDate fecha;
    
    @Column(name = "HORA")
    private LocalTime horaCita;
}
