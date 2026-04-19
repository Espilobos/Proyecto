package com.siamese.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "constante")
public class Constante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_constante")
    private Integer idConstante;

    @Column(length = 25, unique = true)
    private String atributo;

    @Column(length = 150)
    private String valor;
}