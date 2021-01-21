package br.com.springvac.moderncloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itmn_modernizacao")
@Getter
@Setter
public class Modernizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "num_seq")
    private int num_seq;

    @Column(name = "data_modernizacao", nullable = true)
    private String data_modernizacao;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name = "percentual", nullable = true)
    private float percentual;

    @ManyToOne
    @JoinColumn(name = "id_comunidade") // nome da coluna na tabela
    @JsonIgnoreProperties("modernizacoes") // atributo da User que não deve ser preenchido
    private Comunidade comunidade;

}