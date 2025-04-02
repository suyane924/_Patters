package Exercicio03;

public class Main {
    public static void configurarVeiculo(FabricaVeiculoFuturista fabrica) {
        VeiculoFuturista veiculo1 = fabrica.criarVeiculo1();
        VeiculoFuturista veiculo2 = fabrica.criarVeiculo2();
        
        veiculo1.configurar();
        veiculo2.configurar();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Configuração de Veículos para Terra ===");
        configurarVeiculo(new FabricaTerra());
        
        System.out.println("\n=== Configuração de Veículos para Espaço ===");
        configurarVeiculo(new FabricaEspaco());
    }
}
