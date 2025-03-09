package Exercicio09;

public class ExcelRelatorio implements Relatorio {
    @Override
    public void gerar(String[] dados) {
        System.out.println("Gerando relatório em Excel com os dados: ");
        for (String dado : dados) {
            System.out.println(dado);
        }
    }
}
