/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siamese.demo.domain;

/**
 *
 * @author alana
 */


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.ToString;
 
@Data
@ToString(exclude = "mascotas")
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
 
    @NotBlank
    @Column(unique = true, length = 30)
    private String username;
 
    @Column(length = 512, nullable = false)
    private String password;
 
    @Column(length = 20)
    @NotBlank
    private String nombre;
 
    @Column(length = 30)
    @NotBlank
    private String apellidos;
 
    @Column(unique = true, length = 75)
    @Email
    private String correo;
 
    @Column(length = 25)
    private String telefono;
 
    @Column(length = 1024)
    private String rutaImagen;
 
    private boolean activo;
    
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDate fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;
 
    // Relación Many-to-Many con la entidad Rol
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<Rol> roles = new HashSet<>();
}