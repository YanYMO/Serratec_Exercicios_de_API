package org.serratec.aula06.controller;

import jakarta.validation.Valid;
import org.serratec.aula06.domain.Curso;
import org.serratec.aula06.domain.Topico;
import org.serratec.aula06.exception.CursoException;
import org.serratec.aula06.repository.AlunoRepository;
import org.serratec.aula06.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> curso = cursoRepository.findAll();

        if (curso.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new CursoException("Não encontramos um curso com este identificador."));

        return ResponseEntity.ok(curso);
    }

    @GetMapping("/{id}/topicos")
    public ResponseEntity<List<Topico>> listarTopicosPorCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new CursoException("Não encontramos um curso com este identificador."));

        if (curso.getTopicos().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso.getTopicos().stream().toList());
    }

    @PostMapping
    public ResponseEntity<Curso> cadastrar(@Valid @RequestBody Curso curso) {
        cursoRepository.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }
}
