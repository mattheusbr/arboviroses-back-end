package br.uninga.arboviroses.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quarteirao")
@Data
public class Quarteirao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "localidade")
    private String Localidade;

    @Column(name = "numero", nullable = true)
    private String Numero;

    @Column(name = "observacao", nullable = false)
    private String Observacao;

    public Quarteirao(Long id, String localidade, String numero, String observacao) {
        Id = id;
        Localidade = localidade;
        Numero = numero;
        Observacao = observacao;
    }

    public Quarteirao() {
    }
}
