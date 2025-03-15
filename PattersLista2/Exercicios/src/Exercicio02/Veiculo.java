/*Exercício 2: Sistema de Transporte Urbano */

package Exercicio02;

public abstract class Veiculo {
    protected String modelo;
    protected int capacidade;

    public Veiculo(String modelo, int capacidade) {
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    public abstract double calcularConsumo(double distancia, int... passageiros);
}

class Onibus extends Veiculo {
    private double consumoPorKm;

    public Onibus(String modelo, int capacidade, double consumoPorKm) {
        super(modelo, capacidade);
        this.consumoPorKm = consumoPorKm;
    }

    @Override
    public double calcularConsumo(double distancia, int... passageiros) {
        return distancia * consumoPorKm;
    }
}

class Taxi extends Veiculo {
    private double taxaPorPassageiro;

    public Taxi(String modelo, int capacidade, double taxaPorPassageiro) {
        super(modelo, capacidade);
        this.taxaPorPassageiro = taxaPorPassageiro;
    }

    @Override
    public double calcularConsumo(double distancia, int... passageiros) {
        int numPassageiros = (passageiros.length > 0) ? passageiros[0] : 1;
        return distancia * taxaPorPassageiro * numPassageiros;
    }
}
