package br.uninga.arboviroses.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "localidade")
@Data
public class Localidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long Id;
    @Column(name = "descricao", nullable = true)
    private String Descricao;
    @Column(name = "categoria", nullable = true)
    private String Categoria;
    @Column(name = "zona", nullable = true)
    private String Zona;
    @Column(name = "extrato", nullable = true)
    private String Extrato;

    public Localidade(Long id, String descricao, String categoria, String zona, String extrato) {
        Id = id;
        Descricao = descricao;
        Categoria = categoria;
        Zona = zona;
        Extrato = extrato;
    }

    public Localidade() {
    }
}
