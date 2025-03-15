package Exercicio03;

public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("12345", 1000.0, 500.0);
        ContaPoupanca cp = new ContaPoupanca("67890", 2000.0, 1.5);

        cc.depositar(500);
        cc.sacar(1800);
        cp.sacar(500);
        cp.aplicarJuros();
    }
}