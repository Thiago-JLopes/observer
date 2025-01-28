package com.ufjf.padroesdeprojeto;

public class ProdutoEstadoEsgotado extends ProdutoEstado {

    private ProdutoEstadoEsgotado() {}
    private static ProdutoEstadoEsgotado instance = new ProdutoEstadoEsgotado();
    public static ProdutoEstadoEsgotado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Esgotado";
    }

    @Override
    public boolean disponivel(Produto produto) {
        produto.setEstado(ProdutoEstadoDisponivel.getInstance());
        return true;
    }

    @Override
    public boolean emReposicao(Produto produto) {
        produto.setEstado(ProdutoEstadoEmReposicao.getInstance());
        return true;
    }
}