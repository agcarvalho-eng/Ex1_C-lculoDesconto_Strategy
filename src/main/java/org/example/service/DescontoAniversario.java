package org.example.service;

import org.example.model.Venda;

import java.time.LocalDate;

public class DescontoAniversario implements DescontoStrategy {

    @Override
    public double calcular(Venda venda) {
        LocalDate hoje = LocalDate.now();
        LocalDate nascimento = venda.getCliente().getDataNascimento();

        if (nascimento != null &&
                hoje.getDayOfMonth() == nascimento.getDayOfMonth() &&
                hoje.getMonth() == nascimento.getMonth()) {
            return venda.getValorTotal() * 0.15;
        }
        return 0;
    }
}
