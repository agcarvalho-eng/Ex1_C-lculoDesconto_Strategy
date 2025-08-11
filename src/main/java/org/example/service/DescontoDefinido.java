package org.example.service;


import org.example.model.Venda;

public class DescontoDefinido implements DescontoStrategy {
    private double percentual;

    public DescontoDefinido(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Venda venda) {
        double valor = venda.getValorTotal();

        if (valor == 0) {
            return 0.0;
        }

        return valor * percentual / 100;
    }
}
