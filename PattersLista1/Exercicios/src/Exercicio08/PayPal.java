package Exercicio08;

public class PayPal implements MetodoPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado via PayPal.");
    }
}

