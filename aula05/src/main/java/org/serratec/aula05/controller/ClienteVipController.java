package org.serratec.aula05.controller;

import jakarta.validation.Valid;
import org.serratec.aula05.domain.ClienteVip;
import org.serratec.aula05.exception.RecursoNaoEncontradoException;
import org.serratec.aula05.repository.ClienteVipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes-vip")
public class ClienteVipController {

    @Autowired
    private ClienteVipRepository clienteVipRepository;

    @GetMapping
    public List<ClienteVip> listar() {
        return clienteVipRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteVip> clientesPorId(@PathVariable Long id) {
        ClienteVip clienteVip = clienteVipRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Não encontramos usuário com esse identificador"));

        return ResponseEntity.ok(clienteVip);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteVip>> listarPorNome(@RequestParam String nome) {
        List<ClienteVip> clienteVip = clienteVipRepository.findAll().stream()
                .filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());

        if (clienteVip.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clienteVip);
        }
    }

    @PostMapping
    public ResponseEntity<ClienteVip> salvar(@Valid @RequestBody ClienteVip clienteVip) {
        clienteVipRepository.save(clienteVip);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteVip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteVip> atualizarCliente(@Valid @RequestBody ClienteVip cliente, @PathVariable Long id) {

        if (!clienteVipRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            cliente.setId(id);
            cliente = clienteVipRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteVip> deletarCliente(@PathVariable Long id) {

        if (!clienteVipRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            clienteVipRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
}
