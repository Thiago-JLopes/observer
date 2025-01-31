package com.ufjf.padroesdeprojeto;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void cadastrar(Pedido pedido) {
        pedido.addObserver(this);
    }

    @Override
    public void update(Observable pedido, Object arg) {
        if (pedido instanceof Pedido) {
            Pedido p = (Pedido) pedido;
            this.ultimaNotificacao = String.format(
                    "%s, o pedido '%s' mudou para o estado: %s",
                    this.nome, p.getNumeroPedido(), p.getEstadoAtual()
            );
        }
    }
}
