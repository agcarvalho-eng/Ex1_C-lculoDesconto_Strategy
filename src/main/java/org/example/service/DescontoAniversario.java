package org.example.service;

import org.example.model.Venda;

import java.time.LocalDate;

public class DescontoAniversario implements DescontoStrategy {

    @Override
    public double calcular(Venda venda) {
        double valor = venda.getValorTotal();

        if (valor == 0) {
            return 0.0;
        }

        LocalDate hoje = LocalDate.now();
        LocalDate nascimento = venda.getCliente().getDataNascimento();

        if (nascimento != null &&
                hoje.getDayOfMonth() == nascimento.getDayOfMonth() &&
                hoje.getMonth() == nascimento.getMonth()) {
            return valor * 0.15;
        }
        return 0;
    }
}
