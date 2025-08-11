package org.example.service;

import org.example.model.Venda;

public class DescontoProgressivo implements DescontoStrategy {

    @Override
    public double calcular(Venda venda) {
        double percentual = venda.getValorTotal() / 25 / 100;
        percentual = Math.min(percentual, 0.20);
        return venda.getValorTotal() * percentual;
    }
}
