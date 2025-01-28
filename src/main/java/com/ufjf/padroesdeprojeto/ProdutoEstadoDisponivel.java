package com.ufjf.padroesdeprojeto;

public class ProdutoEstadoDisponivel extends ProdutoEstado{

    private  ProdutoEstadoDisponivel(){}
    private  static  ProdutoEstadoDisponivel instance =new ProdutoEstadoDisponivel();
    public  static  ProdutoEstadoDisponivel getInstance(){
        return instance;
    }

    @Override
    public String getEstado() {
        return "Disponivel";
    }

    @Override
    public boolean esgotado(Produto produto) {
        produto.setEstado(ProdutoEstadoEsgotado.getInstance());
        return true;
    }

    @Override
    public boolean emReposicao(Produto produto) {
        produto.setEstado(ProdutoEstadoEmReposicao.getInstance());
        return true;
    }
}
