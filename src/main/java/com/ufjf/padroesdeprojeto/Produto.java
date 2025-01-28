package com.ufjf.padroesdeprojeto;

import java.util.Observable;

public class Produto extends Observable {

    private String nome;
    private int quantidade;
    private ProdutoEstado estado;

    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.estado = ProdutoEstadoDisponivel.getInstance();
    }

    public void setEstado(ProdutoEstado estado) {
        this.estado = estado;
    }

    public boolean disponivel() {
        return estado.disponivel(this);
    }

    public boolean esgotado() {
        return estado.esgotado(this);
    }

    public boolean emReposicao() {
        return estado.emReposicao(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProdutoEstado getEstado() {
        return estado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }

        this.quantidade = quantidade;

        // Notificar os observadores apenas quando a quantidade mudar para maior que zero
        if (this.quantidade >= 0) {
            setChanged();
            notifyObservers(this);
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", estado='" + estado.getEstado() + '\'' +
                '}';
    }
}
