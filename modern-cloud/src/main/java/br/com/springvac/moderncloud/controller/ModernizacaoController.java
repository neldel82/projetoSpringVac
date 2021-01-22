package br.com.springvac.moderncloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springvac.moderncloud.model.Comunidade;
import br.com.springvac.moderncloud.model.Modernizacao;
import br.com.springvac.moderncloud.repository.ModernizacaoRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/modernizacao")
public class ModernizacaoController {

    @Autowired
    private ModernizacaoRepo repo;

    @PostMapping("/modernizacoes")
    public List<Modernizacao> buscarPorId(@RequestBody Comunidade comunidade) {
        List<Modernizacao> lista = repo.findByComunidadeOrderByDataModernizacao(comunidade);
        return lista;
    }

    @PostMapping("/new")
    public ResponseEntity<Modernizacao> novaModernizacao(@RequestBody Modernizacao modernizacao) {

        double porcentagem = repo.somaPorcentagem(modernizacao.getComunidade().getIdComunidade(),modernizacao.getDataModernizacao().getYear());
        
        if (porcentagem + modernizacao.getPercentual() > 100) {
            return ResponseEntity.status(400).build();
        }

        Object obj = repo.existe(modernizacao.getComunidade().getIdComunidade(), modernizacao.getDataModernizacao().getYear(), modernizacao.getDataModernizacao().getMonthValue());

        if (obj != null) {
            return ResponseEntity.status(400).build();
        }

        Modernizacao newModernizacao = repo.save(modernizacao);
        return ResponseEntity.ok(newModernizacao);
    }

    @PostMapping("/porcentagem")
    public double calculaPorcentagem(@RequestBody Modernizacao modernizacao) {

        double porcentagem = repo.somaPorcentagem(modernizacao.getComunidade().getIdComunidade(),modernizacao.getDataModernizacao().getYear());

        return porcentagem;
    }
}