package br.com.springvac.moderncloud.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.springvac.moderncloud.model.User;

// CRUD - Create, Read, Update, Delete
public interface UserRepo extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
    public User findByEmailOrRacf(String email, String racf);
}