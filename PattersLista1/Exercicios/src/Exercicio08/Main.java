package Exercicio08;

public class Main {
    public static void main(String[] args) {
       
        Compra compra = new Compra(150.75);

        MetodoPagamento cartaoCredito = new CartaoCredito();
        MetodoPagamento payPal = new PayPal();
        MetodoPagamento boleto = new Boleto();

        compra.realizarPagamento(cartaoCredito);
        compra.realizarPagamento(payPal);
        compra.realizarPagamento(boleto);
    }
}
