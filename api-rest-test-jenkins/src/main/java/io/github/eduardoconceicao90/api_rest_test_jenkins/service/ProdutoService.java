package io.github.eduardoconceicao90.api_rest_test_jenkins.service;

import io.github.eduardoconceicao90.api_rest_test_jenkins.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> getAllProdutos();

    Produto findById(Long id);

    List<Produto> search(String nome);

    Produto save(Produto produto);

    String delete(Long id);

    Produto update(Produto produto);

}
