package Exercicio09;

public class HtmlRelatorio implements Relatorio {
    @Override
    public void gerar(String[] dados) {
        System.out.println("Gerando relatório em HTML com os dados: ");
        for (String dado : dados) {
            System.out.println(dado);
        }
    }
}

