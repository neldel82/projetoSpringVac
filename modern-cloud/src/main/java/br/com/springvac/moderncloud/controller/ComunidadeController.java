package br.com.springvac.moderncloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springvac.moderncloud.model.Comunidade;
import br.com.springvac.moderncloud.model.User;
import br.com.springvac.moderncloud.repository.ComunidadeRepo;

@RestController
@RequestMapping("/comunidade")
public class ComunidadeController {

    @Autowired
    private ComunidadeRepo repo;

    @PostMapping("/user")
    public List<Comunidade> buscarPorId(@RequestBody User user) {
        List<Comunidade> lista = repo.findByUsuario(user);
        return lista;
    }
}