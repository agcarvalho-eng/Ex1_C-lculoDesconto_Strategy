package org.example.service;

import org.example.model.Venda;

public interface DescontoStrategy {
    double calcular(Venda venda);
}
