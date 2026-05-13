package org.serratec.aula03.controller;

import jakarta.validation.Valid;
import org.serratec.aula03.domain.Cliente;
import org.serratec.aula03.domain.Funcionario;
import org.serratec.aula03.repository.FuncionarioRepository;
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
    public ResponseEntity<Funcionario> funcionarioPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

        if (!funcionario.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(funcionario.get());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Funcionario>> listarPorNome(@RequestParam String cargo) {
        List<Funcionario> funcionario = funcionarioRepository.findAll().stream()
                .filter(f -> f.getcargo().toLowerCase().contains(cargo.toLowerCase()))
                .collect(Collectors.toList());

        if (funcionario.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(funcionario);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarCliente(@Valid @RequestBody Funcionario funcionario, @PathVariable Long id) {

        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            funcionario.setId(id);
            funcionario = funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(funcionario);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deletarCliente(@PathVariable Long id) {

        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
