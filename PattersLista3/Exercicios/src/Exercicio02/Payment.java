/*Plataforma de Pagamentos */

package Exercicio02;

interface Payment {
    void processPayment(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Pagamento de R$" + amount + " processado via Cartão de Crédito.");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Pagamento de R$" + amount + " processado via PayPal.");
    }
}

class BoletoPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Pagamento de R$" + amount + " processado via Boleto Bancário.");
    }
}

class PaymentFactory {
    public static Payment createPayment(String type) {
        if (type.equalsIgnoreCase("creditcard")) {
            return new CreditCardPayment();
        } else if (type.equalsIgnoreCase("paypal")) {
            return new PayPalPayment();
        } else if (type.equalsIgnoreCase("boleto")) {
            return new BoletoPayment();
        } else {
            throw new IllegalArgumentException("Método de pagamento desconhecido");
        }
    }
}



