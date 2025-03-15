package Exercicio02;

public class Main {
    public static void main(String[] args) {
        Onibus onibus = new Onibus("Ônibus Urbano", 40, 2.5);
        Taxi taxi = new Taxi("Sedan", 4, 0.8);

        double consumoOnibus = onibus.calcularConsumo(100);
        double consumoTaxi = taxi.calcularConsumo(50, 3);

        System.out.println("Consumo do ônibus para 100km: " + consumoOnibus + " litros.");
        System.out.println("Consumo do táxi para 50km com 3 passageiros: " + consumoTaxi + " litros.");
    }
}