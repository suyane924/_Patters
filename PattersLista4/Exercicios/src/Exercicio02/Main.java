package Exercicio02;

public class Main {
    public static void main(String[] args) {
        FabricaCriatura fabricaFogo = new FabricaReinoFogo();
        FabricaCriatura fabricaAgua = new FabricaReinoAgua();
        
        Criatura dragao = fabricaFogo.criarCriaturaForte();
        Criatura salamandra = fabricaFogo.criarCriaturaVeloz();
        
        Criatura serpenteMarinha = fabricaAgua.criarCriaturaForte();
        Criatura tritao = fabricaAgua.criarCriaturaVeloz();
        
        dragao.attack();
        salamandra.attack();
        serpenteMarinha.attack();
        tritao.attack();
    }
}
