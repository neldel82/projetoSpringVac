package br.com.springvac.moderncloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springvac.moderncloud.model.Comunidade;
import br.com.springvac.moderncloud.repository.ComunidadeRepo;

@RestController
@RequestMapping("/comunidade")
public class ComunidadeController {
    
    @Autowired
    private ComunidadeRepo repo;

    @GetMapping("/id/{id}")
    public ResponseEntity<Comunidade> buscarPorId(@PathVariable int id){
        Comunidade comunidade = repo.findById(id).orElse(null);

        if(comunidade != null) {
            return ResponseEntity.ok(comunidade);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public List<Comunidade> listarComunidades(){
        List<Comunidade> lista = (List<Comunidade>) repo.findAll();

        return lista;
    }
}