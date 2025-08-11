package org.example;

import org.example.model.Cliente;
import org.example.model.Venda;
import org.example.service.DescontoAniversario;
import org.example.service.DescontoDefinido;
import org.example.service.DescontoProgressivo;
import org.example.service.DescontoStrategy;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "João Silva", LocalDate.of(1990, 8, 11));
        Cliente cliente2 = new Cliente(2, "Maria Souza", LocalDate.of(1985, 3, 15));
        Cliente cliente3 = new Cliente(3, "Ana Oliveira", LocalDate.now()); // aniversário hoje

        Venda venda1 = new Venda(cliente1, LocalDate.now(), 500);
        Venda venda2 = new Venda(cliente2, LocalDate.now(), 1000);
        Venda venda3 = new Venda(cliente3, LocalDate.now(), 800);

        // Definido
        DescontoStrategy descontoFixo = new DescontoDefinido(10);
        System.out.println("Venda 1 - Desconto fixo: R$ " + descontoFixo.calcular(venda1));

        // Progressivo
        DescontoStrategy descontoProgressivo = new DescontoProgressivo();
        System.out.println("Venda 2 - Desconto progressivo: R$ " + descontoProgressivo.calcular(venda2));

        // Aniversário
        DescontoStrategy descontoAniversario = new DescontoAniversario();
        System.out.println("Venda 3 - Desconto aniversário: R$ " + descontoAniversario.calcular(venda3));
    }
}