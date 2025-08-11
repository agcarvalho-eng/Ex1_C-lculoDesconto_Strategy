1. Qual padrão de projeto pode ser utilizado?

O padrão Strategy é o mais adequado, pois permite definir uma família de algoritmos (neste caso, formas de cálculo de desconto), encapsulá-los e torná-los intercambiáveis em tempo de execução, sem modificar o código do cliente.
Assim, basta trocar a estratégia para mudar a forma de calcular o desconto.

2. Como implementar sem utilizar Padrões de Projeto?

Poderíamos criar um único método de cálculo com vários if/else ou switch-case para cada tipo de desconto. Por exemplo:

public double calcularDesconto(String tipo, double valor, LocalDate aniversarioCliente) {
    if (tipo.equals("DEFINIDO")) {
        return valor * 0.10;
    } else if (tipo.equals("PROGRESSIVO")) {
        double desconto = valor / 25 / 100;
        return valor * Math.min(desconto, 0.20);
    } else if (tipo.equals("ANIVERSARIO")) {
        if (aniversarioCliente.equals(LocalDate.now())) {
            return valor * 0.15;
        }
    }
    return 0;
}


3. Quais problemas essa implementação traria?

    Baixa manutenibilidade: adicionar um novo tipo de desconto exigiria alterar o método, aumentando risco de bugs.

    Violação do Princípio Aberto/Fechado (OCP): o código precisaria ser modificado para cada nova regra de desconto.

    Acoplamento: o cliente depende de toda a lógica, mesmo que só use um tipo de desconto.

    Testes mais complexos: todos os tipos de desconto estão misturados, dificultando a cobertura de testes unitários.
