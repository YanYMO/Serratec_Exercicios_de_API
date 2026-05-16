package org.serratec.aula06.controller;

import jakarta.validation.Valid;
import org.serratec.aula06.domain.Avaliacao;
import org.serratec.aula06.exception.AvaliacaoException;
import org.serratec.aula06.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> listar() {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();

        if (avaliacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id) {
        Avaliacao avaliacao = avaliacaoRepository.findAll().stream()
                .filter(a -> a.getId().equals(id)).findFirst()
                .orElseThrow(() -> new AvaliacaoException("Não encontramos uma avaliacao com esse identificador."));

        return ResponseEntity.ok(avaliacao);
    }

    @PostMapping
    public ResponseEntity<Avaliacao> cadastrar(@Valid @RequestBody Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }
}
