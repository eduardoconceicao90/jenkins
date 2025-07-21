package io.github.eduardoconceicao90.api_rest_test_jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/testes")
public class TesteController {

    @GetMapping
    public String teste() {
        return "Teste 2 realizado com sucesso!";
    }

}
