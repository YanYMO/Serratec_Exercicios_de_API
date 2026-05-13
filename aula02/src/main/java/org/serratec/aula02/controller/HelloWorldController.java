package org.serratec.aula02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/resposta")
    public String resposta(@RequestParam String resposta) {
        return resposta;
    }
}
