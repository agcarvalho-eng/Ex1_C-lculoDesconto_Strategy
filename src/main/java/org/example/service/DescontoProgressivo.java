package org.example.service;

import org.example.Main;
import org.example.model.Venda;

public class DescontoProgressivo implements DescontoStrategy {

    @Override
    public double calcular(Venda venda) {
        double valor = venda.getValorTotal();

        if (valor == 0) {
            return 0.0;
        }

        final double PERCENTUAL_MAXIMO = 0.20;
        final double DIVISOR = 2500.0;

        double percentual = valor / DIVISOR;
        percentual = Math.min(percentual, PERCENTUAL_MAXIMO);
        return valor * percentual;
    }
}
