package com.ufjf.padroesdeprojeto;

public class PedidoEstadoCancelado extends PedidoEstado{
    private PedidoEstadoCancelado() {}
    private static PedidoEstadoCancelado instance = new PedidoEstadoCancelado();
    public static PedidoEstado getInstance() {
        return instance;
    }
    @Override
    public String getEstado() {
        return "Cancelado";
    }
}
