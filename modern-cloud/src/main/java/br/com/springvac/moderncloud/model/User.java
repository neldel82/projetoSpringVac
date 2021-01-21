package br.paduan.spring02.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity // classe mapeada no BD
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3,...
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario") // atributo na classe Anuncio
    @JsonIgnoreProperties("usuario") // atributo do 'Anuncio' que não deve ser preenchido
    private List<Anuncio> anuncios;

}
