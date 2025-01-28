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
        this.ultimaNotificacao = this.nome + ", o produto " + produto.toString() + " está disponível!";
        System.out.println(this.ultimaNotificacao);
    }
}
