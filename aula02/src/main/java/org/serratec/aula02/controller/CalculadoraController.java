package org.serratec.aula02.controller;

import com.sun.source.tree.TryTree;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/somar")
    public Double somar(@RequestParam Double a, @RequestParam Double b) {
        return a + b;
    }

    @GetMapping("/subtrair")
    public Double subtrair(@RequestParam Double a, @RequestParam Double b) {
        return a - b;
    }

    @GetMapping("/multiplicar")
    public Double multiplicar(@RequestParam Double a, @RequestParam Double b) {
        return a * b;
    }

    @GetMapping("/dividir")
    public Double dividir(@RequestParam Double a, @RequestParam Double b) {
        try {
            if (b == 0) {
                return 0.0;
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return (a / b);
    }
}
