package Exercicio01;
/*
EXERCICIO 01

Converta um código que calcula a área de um retângulo usando funções para uma versão orientada a objetos. */

public class Retangulo {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double calcularArea() {
        return largura * altura;
    }

    public void exibirArea() {
        double area = calcularArea();
        System.out.println("A área do retângulo é: " + area);
    }

    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(10, 5);
        retangulo.exibirArea(); // Saída: A área do retângulo é: 50
    }
}
