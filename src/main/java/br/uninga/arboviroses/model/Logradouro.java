package br.uninga.arboviroses.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "logradouro")
@Data
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "descricao")
    private String Decricao;
}
