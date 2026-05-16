package org.serratec.aula06.controller;

import jakarta.validation.Valid;
import org.serratec.aula06.domain.Editora;
import org.serratec.aula06.domain.Livro;
import org.serratec.aula06.exception.EditoraException;
import org.serratec.aula06.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping
    public ResponseEntity<List<Editora>> listar() {
        List<Editora> editoras = editoraRepository.findAll();

        if (editoras.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarPorId(@PathVariable Long id) {
        Editora editora = editoraRepository.findById(id)
                .orElseThrow(() -> new EditoraException("Não encontramos uma editora com esse identificador."));

        return ResponseEntity.ok(editora);
    }

    @PostMapping
    public ResponseEntity<Editora> cadastrar(@Valid @RequestBody Editora editora) {
        editoraRepository.save(editora);
        return ResponseEntity.status(HttpStatus.CREATED).body(editora);
    }
}
