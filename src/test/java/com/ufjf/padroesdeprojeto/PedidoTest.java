package com.ufjf.padroesdeprojeto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveNotificarUmCliente() {
        Pedido pedido = new Pedido("12345");
        Cliente cliente = new Cliente("Marcio de Moura");
        cliente.cadastrar(pedido);

        pedido.confirmar();

        assertEquals("Marcio de Moura, o pedido '12345' mudou para o estado: Confirmado", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Pedido pedido = new Pedido("12345");
        Cliente cliente1 = new Cliente("Cliente1");
        Cliente cliente2 = new Cliente("Cliente2");
        cliente1.cadastrar(pedido);
        cliente2.cadastrar(pedido);

        pedido.confirmar();

        assertEquals("Cliente1, o pedido '12345' mudou para o estado: Confirmado", cliente1.getUltimaNotificacao());
        assertEquals("Cliente2, o pedido '12345' mudou para o estado: Confirmado", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteNaoCadastrado() {
        Pedido pedido = new Pedido("12345");
        Cliente cliente = new Cliente("Cliente1");

        pedido.confirmar();

        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSomenteClienteDoPedido() {
        Pedido pedidoA = new Pedido("12345");
        Pedido pedidoB = new Pedido("67890");
        Cliente cliente1 = new Cliente("Cliente1");
        Cliente cliente2 = new Cliente("Cliente2");

        cliente1.cadastrar(pedidoA);
        cliente2.cadastrar(pedidoB);

        pedidoA.confirmar();

        assertEquals("Cliente1, o pedido '12345' mudou para o estado: Confirmado", cliente1.getUltimaNotificacao());
        assertNull(cliente2.getUltimaNotificacao());
    }

    @Test
    void deveMudarEstadosCorretamente() {
        Pedido pedido = new Pedido("12345");
        assertEquals("Recebido", pedido.getEstadoAtual());

        assertTrue(pedido.confirmar());
        assertEquals("Confirmado", pedido.getEstadoAtual());

        assertTrue(pedido.preparar());
        assertEquals("Em Preparo", pedido.getEstadoAtual());

        assertTrue(pedido.finalizar());
        assertEquals("Pronto", pedido.getEstadoAtual());

        assertTrue(pedido.entregar());
        assertEquals("Entregue", pedido.getEstadoAtual());

       assertFalse(pedido.cancelar());
       assertEquals("Entregue", pedido.getEstadoAtual());
    }
}