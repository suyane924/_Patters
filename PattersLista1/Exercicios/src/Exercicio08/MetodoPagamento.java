package Exercicio08;

/*
EXERCICIO 08

Sistema de Pagamentos
User Story: Como um cliente de uma loja online, eu quero poder pagar minhas compras usando diferentes métodos de pagamento (cartão de crédito, PayPal, boleto), para que eu possa escolher a opção mais conveniente. */

public interface MetodoPagamento {
    void pagar(double valor);
}
