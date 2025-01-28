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

    public void cadastrar(Produto produto) {
        produto.addObserver(this);
    }

    @Override
    public void update(Observable produto, Object arg) {
        if (produto instanceof Produto) {
            Produto p = (Produto) produto;
            this.ultimaNotificacao = String.format(
                    "%s, o produto '%s' está disponível com quantidade %d. Estado atual: %s",
                    this.nome, p.getNome(), p.getQuantidade(), p.getNomeEstado()
            );
            //System.out.println(this.ultimaNotificacao);
        }
    }
}
