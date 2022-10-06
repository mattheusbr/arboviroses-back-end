package br.uninga.arboviroses.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bairro")
@Data
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "descricao")
    private String Decricao;
}
