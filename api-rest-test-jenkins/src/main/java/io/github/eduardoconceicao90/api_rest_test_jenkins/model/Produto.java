package io.github.eduardoconceicao90.api_rest_test_jenkins.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private Integer quantidade;
    private Double preco;
}
