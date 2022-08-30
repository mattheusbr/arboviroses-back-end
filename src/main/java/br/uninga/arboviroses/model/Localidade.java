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
    @Column(name = "id", nullable = false)
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
        this.Id = id;
        this.Descricao = descricao;
        this.Categoria = categoria;
        this.Zona = zona;
        this.Extrato = extrato;
    }

    public Localidade() {
    }
}
