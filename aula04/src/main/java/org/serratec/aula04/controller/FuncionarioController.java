package org.serratec.aula04.controller;

import jakarta.validation.Valid;
import org.serratec.aula04.domain.Funcionario;
import org.serratec.aula04.exception.RecursoNaoEncontradoException;
import org.serratec.aula04.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        if (funcionarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(funcionarios);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> funcionariosPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Não encontramos usuário com esse identificador"));

        return ResponseEntity.ok(funcionario);

        /*if (!funcionario.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(funcionario.get());
        }*/
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Funcionario>> listarPorNome(@RequestParam String nome) {
        List<Funcionario> funcionario = funcionarioRepository.findAll().stream()
                .filter(f -> f.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());

        if (funcionario.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(funcionario);
        }
    }

    @GetMapping("/cargo")
    public ResponseEntity<List<Funcionario>> listarPorCargo(@RequestParam String cargo) {
        List<Funcionario> funcionario = funcionarioRepository.findAll().stream()
                .filter(f -> f.getCargo().toLowerCase().contains(cargo.toLowerCase()))
                .collect(Collectors.toList());

        if (funcionario.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(funcionario);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> cadastrarFuncionario(@Valid @RequestBody Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@Valid @RequestBody Funcionario funcionario, @PathVariable Long id) {

        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            funcionario.setId(id);
            funcionario = funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(funcionario);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deletarFuncionario(@PathVariable Long id) {

        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
