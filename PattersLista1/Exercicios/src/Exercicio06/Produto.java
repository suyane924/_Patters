package Exercicio06;

/*
EXERCICIO 06

Sistema de Cadastro de Produtos
User Story: Como um vendedor, eu quero poder cadastrar produtos, atualizar seus preços e exibir um relatório de todos os produtos cadastrados, para que eu possa gerenciar meu estoque de forma eficiente. */

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEmEstoque += quantidade;
        }
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > 0 && this.quantidadeEmEstoque - quantidade >= 0) {
            this.quantidadeEmEstoque -= quantidade;
        } else {
            System.out.println("Erro: Estoque insuficiente para remover a quantidade solicitada.");
        }
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
    }
}

