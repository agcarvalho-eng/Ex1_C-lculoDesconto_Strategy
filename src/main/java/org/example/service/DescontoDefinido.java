package org.example.service;


import org.example.model.Venda;

public class DescontoDefinido implements DescontoStrategy {
    private double percentual;

    public DescontoDefinido(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Venda venda) {
        return venda.getValorTotal() * percentual / 100;
    }
}
