/*Exercício 3: Sistema de Banco Digital */

package Exercicio03;

public abstract class ContaBancaria {
    protected String numero;
    protected double saldo;

    public ContaBancaria(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public abstract boolean sacar(double valor);

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}

class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, double saldo, double limiteChequeEspecial) {
        super(numero, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && (saldo + limiteChequeEspecial) >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Saldo atual: R$" + saldo);
            return true;
        } else {
            System.out.println("Saque não permitido. Saldo insuficiente.");
            return false;
        }
    }
}

class ContaPoupanca extends ContaBancaria {
    private double taxaJuros;

    public ContaPoupanca(String numero, double saldo, double taxaJuros) {
        super(numero, saldo);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Saldo atual: R$" + saldo);
            return true;
        } else {
            System.out.println("Saque não permitido. Saldo insuficiente.");
            return false;
        }
    }

    public void aplicarJuros() {
        saldo += saldo * (taxaJuros / 100);
        System.out.println("Juros aplicados. Novo saldo: R$" + saldo);
    }
}
    

