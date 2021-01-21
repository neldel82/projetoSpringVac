package br.paduan.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.paduan.spring02.model.Anuncio;

public interface AnuncioRepo extends CrudRepository<Anuncio, Integer> {
    
}
