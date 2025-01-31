package com.ufjf.padroesdeprojeto;

public class PedidoEstadoRecebido extends PedidoEstado {
    private PedidoEstadoRecebido() {}
    private static PedidoEstadoRecebido instance = new PedidoEstadoRecebido();
    public static PedidoEstadoRecebido getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Recebido";
    }

    @Override
    public boolean confirmar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoConfirmado.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

}