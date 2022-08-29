package br.uninga.arboviroses.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tipo_imovel")
@Data
public class TipoImovel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long Id;

    @Column(name = "sigla")
    private String Sigla;

    @Column(name = "descricao")
    private String Decricao;
}
