package Exercicio05;
/*
EXERCICIO 05

Calculadora de Formas Geométricas
User Story: Como um estudante de matemática, eu quero poder calcular a área e o perímetro de diferentes formas geométricas, para que eu possa resolver problemas de geometria de forma rápida. */



class Retangulo {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double calcularArea() {
        return largura * altura;
    }

    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }

    public void exibirDetalhes() {
        System.out.println("Retângulo:");
        System.out.println("Largura: " + largura);
        System.out.println("Altura: " + altura);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
}

class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    public void exibirDetalhes() {
        System.out.println("Círculo:");
        System.out.println("Raio: " + raio);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
}

public class CalcularFormas {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(5, 10);
        retangulo.exibirDetalhes();

        System.out.println();

        Circulo circulo = new Circulo(7);
        circulo.exibirDetalhes();
    }
}
