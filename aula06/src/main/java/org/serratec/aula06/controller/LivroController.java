package org.serratec.aula06.controller;

import jakarta.validation.Valid;
import org.serratec.aula06.domain.Livro;
import org.serratec.aula06.exception.LivroException;
import org.serratec.aula06.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroRepository.findAll();

        if (livros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new LivroException("Não encontramos uma livro com esse identificador."));

        return ResponseEntity.ok(livro);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@Valid @RequestBody Livro livro) {
        livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livro);
    }
}
