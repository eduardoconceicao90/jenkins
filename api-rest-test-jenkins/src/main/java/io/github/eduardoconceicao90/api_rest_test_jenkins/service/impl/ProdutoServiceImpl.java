package io.github.eduardoconceicao90.api_rest_test_jenkins.service.impl;

import io.github.eduardoconceicao90.api_rest_test_jenkins.model.Produto;
import io.github.eduardoconceicao90.api_rest_test_jenkins.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public List<Produto> getAllProdutos() {
        return produtos;
    }

    @Override
        public Produto findById(Long id) {
        for(int i = 0;i < produtos.size();i++){
            if(produtos.get(i).getId() == id){
                return produtos.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Produto> search(String nome) {
        return produtos.stream()
                .filter(x -> x.getNome().startsWith(nome))
                .collect(Collectors.toList());
    }

    @Override
    public Produto save(Produto produto) {
        Produto producto = new Produto();

        producto.setId(produto.getId());
        producto.setNome(produto.getNome());
        producto.setQuantidade(produto.getQuantidade());
        producto.setPreco(produto.getPreco());

        produtos.add(producto);
        return producto;
    }

    @Override
    public String delete(Long id) {
        produtos.removeIf(x -> x.getId().equals(id));
        return "Produto eliminado! " + id;
    }

    @Override
    public Produto update(Produto produto) {
        int idPos = 0;
        Long id = 0L;

        for(int i = 0;i < produtos.size();i++){
            if(produtos.get(i).getId() == (produto.getId())){
                id = produto.getId();
                idPos = i;
                break;
            }
        }

        Produto produto1 = new Produto();

        produto1.setId(id);
        produto1.setNome(produto.getNome());
        produto1.setQuantidade(produto.getQuantidade());
        produto1.setPreco(produto.getPreco());

        return produto1;
    }

}
