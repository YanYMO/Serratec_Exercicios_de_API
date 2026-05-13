package org.serratec.aula02.controller;

import org.serratec.aula02.domain.VeiculoDomain;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static List<VeiculoDomain> veiculos = new ArrayList<>();

    static {
        veiculos.add(new VeiculoDomain(1L, "Toyota", "Corolla"));
        veiculos.add(new VeiculoDomain(2L, "Honda", "Civic"));
        veiculos.add(new VeiculoDomain(3L, "Fiat", "Uno"));
        veiculos.add(new VeiculoDomain(4L, "Toyota", "Corolla"));
        veiculos.add(new VeiculoDomain(5L, "Honda", "Civic"));
        veiculos.add(new VeiculoDomain(6L, "Fiat", "Uno"));
        veiculos.add(new VeiculoDomain(7L, "Toyota", "Corolla"));
        veiculos.add(new VeiculoDomain(8L, "Honda", "Civic"));
        veiculos.add(new VeiculoDomain(9L, "Fiat", "Uno"));
    }

    @GetMapping
    public List<VeiculoDomain> listar() {
        return veiculos;
    }

    @GetMapping("/{id}")
    public VeiculoDomain listarPorId(@PathVariable Long id) {
        return veiculos.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoDomain cadastrar(@RequestBody VeiculoDomain v) {
        veiculos.add(v);
        return v;
    }

    @PutMapping("/{id}")
    public VeiculoDomain atualizar(@RequestBody VeiculoDomain v, @PathVariable Long id) {
        for (int i = 0; i<veiculos.size(); i++) {
            if (veiculos.get(i).getId().equals(id)) {
                veiculos.set(i, v);
                return veiculos.get(i);
            }
        }
        /*
        for (VeiculoDomain veiculo : veiculos) {
            if (veiculo.getId().equals(v.getId())) {
                veiculo.setId(v.getId());
                veiculo.setMarca(v.getMarca());
                veiculo.setModelo(v.getModelo());
                return veiculo;
            }
        }
        */
        return null;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        for (int i = 0; i<veiculos.size(); i++) {
            if (veiculos.get(i).getId().equals(id)) {
                veiculos.remove(i);
            }
        }
    }

    @GetMapping("/buscar")
    public Stream<VeiculoDomain> listarPorMarca(@RequestParam String marca) {
        return veiculos.stream().filter(veiculo -> veiculo.getMarca().equalsIgnoreCase(marca));
    }
}
