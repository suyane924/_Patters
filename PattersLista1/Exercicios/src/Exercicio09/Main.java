package Exercicio09;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();

        String[] dados = {"Vendas do mês: R$ 50,000", "Lucro: R$ 15,000", "Custo: R$ 35,000"};
        
        Relatorio pdfRelatorio = new PdfRelatorio();
        Relatorio excelRelatorio = new ExcelRelatorio();
        Relatorio htmlRelatorio = new HtmlRelatorio();

        gerente.solicitarRelatorio(pdfRelatorio, dados);
        gerente.solicitarRelatorio(excelRelatorio, dados);
        gerente.solicitarRelatorio(htmlRelatorio, dados);
    }
}
