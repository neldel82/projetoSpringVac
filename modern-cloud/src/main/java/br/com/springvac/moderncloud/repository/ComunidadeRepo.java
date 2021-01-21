package br.com.springvac.moderncloud.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.springvac.moderncloud.model.Comunidade;

public interface ComunidadeRepo extends CrudRepository<Comunidade, Integer> {
    
}