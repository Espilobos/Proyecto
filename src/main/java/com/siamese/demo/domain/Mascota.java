package com.siamese.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id;
    
    @Column(name= "nombre_dueño")
    private String nombreDueño;
    
    @Column(name= "nombre_mascota")
    private String nombreMascota;
    
    private int edad;
    
    private String raza;
    
    private String especie;
}
