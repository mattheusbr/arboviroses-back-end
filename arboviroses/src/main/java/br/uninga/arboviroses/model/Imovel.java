package br.uninga.arboviroses.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "imovel")
@Data
public class Imovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long Id;
    @Column(name = "localidade")
    private String Localidade;
    @Column(name = "quarteirao")
    private String Quarteirao;
    @Column(name = "logradouro")
    private String Logradouro;
    @Column(name = "numero")
    private String Numero;
    @Column(name = "bairro")
    private String Bairro;
    @Column(name = "tipoImovel")
    private String TipoImovel;
    @Column(name = "complemento")
    private String Complemento;
    @Column(name = "sequencia")
    private String Sequencia;
    @Column(name = "telefoneResidencial")
    private String TelefoneResidencial;
    @Column(name = "telefoneRecado")
    private String TelefoneRecado;
    @Column(name = "observacao", nullable = false)
    private String Observacao;

    public Imovel(Long id,
                  String localidade,
                  String quarteirao,
                  String logradouro,
                  String numero,
                  String bairro,
                  String tipoImovel,
                  String complemento,
                  String sequencia,
                  String telefoneResidencial,
                  String telefoneRecado,
                  String observacao) {
        this.Id = id;
        this.Localidade = localidade;
        this.Quarteirao = quarteirao;
        this.Logradouro = logradouro;
        this.Numero = numero;
        this.Bairro = bairro;
        this.TipoImovel = tipoImovel;
        this.Complemento = complemento;
        this.Sequencia = sequencia;
        this.TelefoneResidencial = telefoneResidencial;
        this.TelefoneRecado = telefoneRecado;
        this.Observacao = observacao;
    }

    public Imovel() {
    }
}
