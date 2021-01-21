package br.com.springvac.moderncloud.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itmn_comunidade")
@Getter
@Setter
public class Comunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_comunidade")
    private int id;

    @Column(name = "nome_comunidade", length = 100, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_usuario") // nome da coluna na tabela
    //@JsonIgnoreProperties("comunidades") // atributo do User que não deve ser preenchido
    private User usuario;


    @OneToMany(mappedBy = "comunidade") // atributo na classe Modernizacao
    @JsonIgnoreProperties("comunidade") // atributo da 'Modernizacao' que não deve ser preenchido
    private List<Modernizacao> modernizacoes;

}