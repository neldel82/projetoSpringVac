package br.com.springvac.moderncloud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.springvac.moderncloud.model.Comunidade;
import br.com.springvac.moderncloud.model.User;

public interface ComunidadeRepo extends CrudRepository<Comunidade, Integer> {

    public List<Comunidade> findByUsuario(User usuario);

}