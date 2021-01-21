package br.com.springvac.moderncloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity // classe mapeada no BD
@Table(name = "tbl_usuario")
@Getter
@Setter
public class User {
    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3,...
    @Column(name = "id")
    private int id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "linkfoto", length = 200, nullable = true)
    private String linkFoto;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "racf", length = 7, nullable = false, unique = true)
    private String racf;

    @Column(name = "senha", length = 30, nullable = false)
    private String senha;
/* 
    @OneToMany(mappedBy = "usuario") // atributo na classe Comunidade
    @JsonIgnoreProperties("usuario") // atributo do 'Comunidade' que não deve ser preenchido
    private List<Comunidade> comunidades;
 */
}