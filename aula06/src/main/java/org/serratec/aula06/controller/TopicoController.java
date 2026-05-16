package org.serratec.aula06.controller;

import jakarta.validation.Valid;
import org.serratec.aula06.domain.Aluno;
import org.serratec.aula06.domain.Topico;
import org.serratec.aula06.exception.TopicoException;
import org.serratec.aula06.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        List<Topico> topicos = topicoRepository.findAll();

        if (topicos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> buscarPorId(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new TopicoException("Não encontramos uma Topico com esse identificador."));

        return ResponseEntity.ok(topico);
    }

    @PostMapping
    public ResponseEntity<Topico> cadastrar(@Valid @RequestBody Topico topico) {
        topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topico);
    }
}
