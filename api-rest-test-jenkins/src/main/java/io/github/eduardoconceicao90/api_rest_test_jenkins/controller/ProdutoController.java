package io.github.eduardoconceicao90.api_rest_test_jenkins.controller;

import io.github.eduardoconceicao90.api_rest_test_jenkins.model.Produto;
import io.github.eduardoconceicao90.api_rest_test_jenkins.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto agregarProduto(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public Produto buscarProduto(@PathVariable Long id){
        return produtoService.findById(id);
    }

    @PutMapping
    public Produto actualizarProduto(@RequestBody Produto produto){
        return produtoService.update(produto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return produtoService.delete(id);
    }
}
