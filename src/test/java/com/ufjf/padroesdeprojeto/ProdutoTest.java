package com.ufjf.padroesdeprojeto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void deveNotificarUmCliente(){
        Produto produto = new Produto("Notebook A", 0);
        Cliente cliente = new Cliente("Marcio de Moura");
        cliente.cadastrar(produto);
        produto.setQuantidade(25);

        assertEquals("Marcio de Moura, o produto 'Notebook A' está disponível com quantidade 25. Estado atual: Disponivel", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes(){
        Produto produto = new Produto("Notebook A", 0);
        Cliente cliente1 = new Cliente("Cliente1");
        Cliente cliente2 = new Cliente("Cliente2");
        cliente1.cadastrar(produto);
        cliente2.cadastrar(produto);
        produto.setQuantidade(25);

        assertEquals("Cliente1, o produto 'Notebook A' está disponível com quantidade 25. Estado atual: Disponivel", cliente1.getUltimaNotificacao());
        assertEquals("Cliente2, o produto 'Notebook A' está disponível com quantidade 25. Estado atual: Disponivel", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente(){
        Produto produto = new Produto("Notebook A", 0);
        Cliente cliente1 = new Cliente("Cliente1");
        produto.setQuantidade(25);

        assertEquals(null, cliente1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteProdutoA() {
        Produto produtoA = new Produto("Notebook A", 0);
        Produto produtoB = new Produto("Notebook B", 0);
        Cliente cliente1 = new Cliente("Cliente1");
        Cliente cliente2 = new Cliente("Cliente2");
        cliente1.cadastrar(produtoA);
        cliente2.cadastrar(produtoB);
        produtoA.setQuantidade(25);

        assertEquals("Cliente1, o produto 'Notebook A' está disponível com quantidade 25. Estado atual: Disponivel", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}