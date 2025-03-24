package Exercicio02;

public class Main {
    public static void main(String[] args) {
        Payment creditCardPayment = PaymentFactory.createPayment("creditcard");
        creditCardPayment.processPayment(150.75);

        Payment payPalPayment = PaymentFactory.createPayment("paypal");
        payPalPayment.processPayment(200.50);

        Payment boletoPayment = PaymentFactory.createPayment("boleto");
        boletoPayment.processPayment(300.00);
    }
}
