package Exercicio06;

public class Main {
    public static void main(String[] args) {
        CadastroProdutos cadastro = new CadastroProdutos();

        Produto p1 = new Produto("Camiseta", 49.90, 100);
        Produto p2 = new Produto("Tênis", 199.90, 50);
        Produto p3 = new Produto("Jaqueta", 129.90, 30);

        cadastro.adicionarProduto(p1);
        cadastro.adicionarProduto(p2);
        cadastro.adicionarProduto(p3);

        cadastro.exibirRelatorio();

        cadastro.atualizarPreco("Camiseta", 59.90);

        p1.adicionarEstoque(20);
        p2.removerEstoque(10);

        cadastro.exibirRelatorio();
    }
}
