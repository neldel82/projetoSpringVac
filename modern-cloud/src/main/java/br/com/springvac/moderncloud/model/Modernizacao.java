package br.com.springvac.moderncloud.model;

import java.time.LocalDate;

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
    private int numSeq;

    @Column(name = "data_modernizacao", nullable = true)
    private LocalDate dataModernizacao;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name = "percentual", nullable = true)
    private float percentual;

    @ManyToOne
    @JoinColumn(name = "id_comunidade")
    @JsonIgnoreProperties("modernizacoes")
    private Comunidade comunidade;
}