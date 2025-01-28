package com.ufjf.padroesdeprojeto;

public class ProdutoEstadoEmReposicao extends ProdutoEstado {

    private ProdutoEstadoEmReposicao() {}
    private static ProdutoEstadoEmReposicao instance = new ProdutoEstadoEmReposicao();
    public static ProdutoEstadoEmReposicao getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Reposição";
    }

    @Override
    public boolean disponivel(Produto produto) {
        produto.setEstado(ProdutoEstadoDisponivel.getInstance());
        return true;
    }

    @Override
    public boolean esgotado(Produto produto) {
        produto.setEstado(ProdutoEstadoEsgotado.getInstance());
        return true;
    }
}