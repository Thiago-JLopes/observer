package com.ufjf.padroesdeprojeto;


import java.util.Observable;

public class Pedido extends Observable {
    private String numeroPedido;
    private PedidoEstado estado;

    public Pedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.estado = PedidoEstadoRecebido.getInstance();
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public String getEstadoAtual() {
        return estado.getEstado();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public boolean confirmar() {
        return estado.confirmar(this);
    }

    public boolean preparar() {
        return estado.preparar(this);
    }

    public boolean finalizar() {
        return estado.finalizar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }
}
