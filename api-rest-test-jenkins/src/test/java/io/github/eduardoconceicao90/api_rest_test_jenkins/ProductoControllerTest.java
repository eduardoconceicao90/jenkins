package io.github.eduardoconceicao90.api_rest_test_jenkins;

import io.github.eduardoconceicao90.api_rest_test_jenkins.controller.ProdutoController;
import io.github.eduardoconceicao90.api_rest_test_jenkins.model.Produto;
import io.github.eduardoconceicao90.api_rest_test_jenkins.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductoControllerTest {

    // Teste de unidade para o ProdutoController

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoService produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvarProduto_quandoChamado_retornaProduto() {
        Produto produto = new Produto(1L, "Produto 1", 10, 100.0);
        when(produtoService.save(any(Produto.class))).thenReturn(produto);

        Produto resultado = produtoController.salvarProduto(produto);

        assertNotNull(resultado);
        assertEquals(produto.getId(), resultado.getId());
        verify(produtoService, times(1)).save(produto);
    }

    @Test
    void listarProdutos_quandoChamado_retornaListaDeProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L, "Produto 1", 10, 100.0));
        produtos.add(new Produto(2L, "Produto 2", 5, 50.0));
        when(produtoService.getAllProdutos()).thenReturn(produtos);

        List<Produto> resultado = produtoController.listarProdutos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(produtoService, times(1)).getAllProdutos();
    }

    @Test
    void buscarProduto_quandoChamadoComId_retornaProduto() {
        Produto produto = new Produto(1L, "Produto 1", 10, 100.0);
        when(produtoService.findById(1L)).thenReturn(produto);

        Produto resultado = produtoController.buscarProduto(1L);

        assertNotNull(resultado);
        assertEquals(produto.getId(), resultado.getId());
        verify(produtoService, times(1)).findById(1L);
    }

    @Test
    void atualizarProduto_quandoChamado_retornaProdutoAtualizado() {
        Produto produto = new Produto(1L, "Produto 1", 10, 100.0);
        when(produtoService.update(any(Produto.class))).thenReturn(produto);

        Produto resultado = produtoController.atualizarProduto(produto);

        assertNotNull(resultado);
        assertEquals(produto.getId(), resultado.getId());
        verify(produtoService, times(1)).update(produto);
    }

    @Test
    void eliminarProduto_quandoChamado_retornaMensagemDeEliminacao() {
        when(produtoService.delete(1L)).thenReturn("Produto eliminado!");

        String resultado = produtoController.deletarProduto(1L);

        assertNotNull(resultado);
        assertEquals("Produto eliminado!", resultado);
        verify(produtoService, times(1)).delete(1L);
    }

}
