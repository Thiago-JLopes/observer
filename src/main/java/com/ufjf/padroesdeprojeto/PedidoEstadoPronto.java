package com.ufjf.padroesdeprojeto;

public class PedidoEstadoPronto extends PedidoEstado {
    private PedidoEstadoPronto() {}
    private static PedidoEstadoPronto instance = new PedidoEstadoPronto();
    public static PedidoEstadoPronto getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pronto";
    }

    @Override
    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
