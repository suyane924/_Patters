package Exercicio06;

import java.util.ArrayList;
import java.util.List;

public class CadastroProdutos {
    private List<Produto> produtos;

    public CadastroProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
    public void atualizarPreco(String nomeProduto, double novoPreco) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nomeProduto)) {
                produto.atualizarPreco(novoPreco);
                System.out.println("Preço do produto '" + nomeProduto + "' atualizado para R$ " + novoPreco);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void exibirRelatorio() {
        System.out.println("Relatório de Produtos Cadastrados:");
        for (Produto produto : produtos) {
            produto.exibirDetalhes();
            System.out.println("----------------------------");
        }
    }
}

