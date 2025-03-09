package Exercicio09;

public class Gerente {
    public void solicitarRelatorio(Relatorio relatorio, String[] dados) {
        relatorio.gerar(dados);
    }
}

