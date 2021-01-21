package br.com.springvac.moderncloud.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.springvac.moderncloud.model.User;

// CRUD - Create, Read, Update, Delete
public interface UserRepo extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
    public User findByEmailAndSenha(String email, String senha);
    public User findByRacfAndSenha(String racf, String senha);
    public User findByEmailOrRacf(String email, String racf);
}