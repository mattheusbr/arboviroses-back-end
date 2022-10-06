package br.uninga.arboviroses.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pncd")
@Data
public class Pncd implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String data;

    @Column
    private String hora;

    @Column
    private String a1;

    @Column
    private String a2;

    @Column
    private String b;

    @Column
    private String c;

    @Column
    private String d1;

    @Column
    private String d2;

    @Column
    private String e;

    @Column
    private String tipo01;

    @Column
    private String quantidade01;

    @Column
    private String tipo02;

    @Column
    private String quantidade02;

    @Column(name = "tipodeimovel")
    private String tipodeImovel;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    private String sequencia;

    @Column(name = "numerodemoradores")
    private String numerodeMoradores;

    @Column(name = "telefoneresidencial")
    private String telefoneResidencial;

    @Column(name = "telefonerecado")
    private String telefoneRecado;

    @Column(name = "nomemorador")
    private String nomeMorador;

    @Column
    private String cpf;

    @Column(name = "datanascimento")
    private String dataNascimento;

    @Column(name = "numerodocartaosus")
    private String numerodoCartaoSus;

    public Pncd(Long id, String data, String hora, String a1, String a2, String b, String c, String d1, String d2, String e, String tipo01, String quantidade01, String tipo02, String quantidade02, String tipodeImovel, String numero, String complemento, String sequencia, String numerodeMoradores, String telefoneResidencial, String telefoneRecado, String nomeMorador, String cpf, String dataNascimento, String numerodoCartaoSus) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.a1 = a1;
        this.a2 = a2;
        this.b = b;
        this.c = c;
        this.d1 = d1;
        this.d2 = d2;
        this.e = e;
        this.tipo01 = tipo01;
        this.quantidade01 = quantidade01;
        this.tipo02 = tipo02;
        this.quantidade02 = quantidade02;
        this.tipodeImovel = tipodeImovel;
        this.numero = numero;
        this.complemento = complemento;
        this.sequencia = sequencia;
        this.numerodeMoradores = numerodeMoradores;
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneRecado = telefoneRecado;
        this.nomeMorador = nomeMorador;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.numerodoCartaoSus = numerodoCartaoSus;
    }

    public Pncd() {
    }
}
