package Exercicio03;
/*
EXERCICIO 03

Converta um código que simula um sistema bancário simples (com contas, depósitos e saques) usando funções para uma versão orientada a objetos.*/

import java.util.ArrayList;
import java.util.List;

class Conta {
    private int numero;
    private double saldo;

    public Conta(int numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
        System.out.println("Conta " + numero + " criada com saldo inicial de R$" + saldoInicial + ".");
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado na conta " + numero + ". Novo saldo: R$" + saldo + ".");
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado na conta " + numero + ". Novo saldo: R$" + saldo + ".");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo da conta " + numero + ": R$" + saldo + ".");
    }
}

public class SistemaBancario {
    private List<Conta> contas = new ArrayList<>();

    public void criarConta(int numero, double saldoInicial) {
        contas.add(new Conta(numero, saldoInicial));
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada.");
        return null;
    }

    public static void main(String[] args) {
        SistemaBancario sistema = new SistemaBancario();
        sistema.criarConta(123, 1000);
        Conta conta = sistema.buscarConta(123);
        if (conta != null) {
            conta.depositar(500);
            conta.sacar(200);
            conta.consultarSaldo();
        }
    }
}
