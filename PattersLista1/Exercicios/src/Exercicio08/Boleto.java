package Exercicio08;

public class Boleto implements MetodoPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com boleto.");
    }
}

