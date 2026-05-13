package org.serratec.aula03.controller;

import jakarta.validation.Valid;
import org.serratec.aula03.domain.Cliente;
import org.serratec.aula03.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> clientesPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (!cliente.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cliente.get());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Cliente>> listarPorNome(@RequestParam String nome) {
        List<Cliente> cliente = clienteRepository.findAll().stream()
                .filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());

        if (cliente.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(cliente);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {

        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            cliente.setId(id);
            cliente = clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id) {

        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            clienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
