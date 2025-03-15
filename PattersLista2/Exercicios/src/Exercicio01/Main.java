package Exercicio01;

public class Main {
    public static void main(String[] args) {
        FuncionarioEfetivo efetivo = new FuncionarioEfetivo("João", 5000.0, "Desenvolvedor", 2000.0);
        FuncionarioTerceirizado terceirizado = new FuncionarioTerceirizado("Maria", 4000.0, "Analista", 1500.0);

        System.out.println("Vencimentos de " + efetivo.nome + ": R$ " + efetivo.calcularVencimentos());
        System.out.println("Vencimentos de " + terceirizado.nome + ": R$ " + terceirizado.calcularVencimentos());
    }
}