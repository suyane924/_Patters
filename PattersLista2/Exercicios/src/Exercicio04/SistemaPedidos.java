/*Exercício 4: Sistema de Pedidos de Restaurante */

package Exercicio04;

import java.util.ArrayList;
import java.util.List;

class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}

class Pedido {
    protected int numero;
    protected List<Item> itens;

    public Pedido(int numero) {
        this.numero = numero;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido " + numero + " - Total: R$ " + calcularTotal();
    }
}

class PedidoDelivery extends Pedido {
    private double taxaEntrega;

    public PedidoDelivery(int numero, double taxaEntrega) {
        super(numero);
        this.taxaEntrega = taxaEntrega;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + taxaEntrega;
    }
}

public class SistemaPedidos {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(1);
        pedido1.adicionarItem(new Item("Hambúrguer", 15.0));
        pedido1.adicionarItem(new Item("Batata Frita", 8.0));
        System.out.println(pedido1);

        PedidoDelivery pedido2 = new PedidoDelivery(2, 5.0);
        pedido2.adicionarItem(new Item("Pizza", 30.0));
        pedido2.adicionarItem(new Item("Refrigerante", 10.0));
        System.out.println(pedido2);
    }
}
