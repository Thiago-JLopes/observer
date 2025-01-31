package com.ufjf.padroesdeprojeto;

public class PedidoEstadoEmPreparo extends PedidoEstado {
    private PedidoEstadoEmPreparo() {}
    private static PedidoEstadoEmPreparo instance = new PedidoEstadoEmPreparo();
    public static PedidoEstadoEmPreparo getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Preparo";
    }

    @Override
    public boolean finalizar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPronto.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}