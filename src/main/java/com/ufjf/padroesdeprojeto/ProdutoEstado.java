package com.ufjf.padroesdeprojeto;

public abstract class ProdutoEstado {
    public abstract String getEstado();

    public boolean disponivel(Produto produto) {
        return false;
    }

    public boolean esgotado(Produto produto) {
        return false;
    }

    public boolean emReposicao(Produto produto) {
        return false;
    }
}
