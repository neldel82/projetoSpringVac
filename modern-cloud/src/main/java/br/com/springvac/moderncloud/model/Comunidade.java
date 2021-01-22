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
    private int idComunidade;

    @Column(name = "nome_comunidade", length = 100, nullable = false)
    private String nomeComunidade;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User usuario;


    @OneToMany(mappedBy = "comunidade")
    @JsonIgnoreProperties("comunidade")
    private List<Modernizacao> modernizacoes;
}