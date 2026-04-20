package com.siamese.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @ToString.Exclude
    private Usuario usuario;
    
    private String nombre;
    private String especie;
    private String raza;
    
    
    @Column(name= "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    
    @Column(name= "ruta_imagen")
    private String rutaImagen;
    
    private boolean activo;
    
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDate fechaCreacion;
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;
    
    @OneToMany(mappedBy = "mascota")
    private List<Cita> citas;
}
