package Exercicio09;

public class PdfRelatorio implements Relatorio {
    @Override
    public void gerar(String[] dados) {
        System.out.println("Gerando relatório em PDF com os dados: ");
        for (String dado : dados) {
            System.out.println(dado);
        }
    }
}

