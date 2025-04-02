package Exercicio01;

public class Main {
    public static void main(String[] args) {
        FabricaBrinquedo fabricaPlastico = new FabricaPlastico();
        FabricaBrinquedo fabricaMadeira = new FabricaMadeira();
        
        Brinquedo carrinhoPlastico = fabricaPlastico.criarCarrinho();
        Brinquedo bonecaPlastico = fabricaPlastico.criarBoneca();
        
        Brinquedo carrinhoMadeira = fabricaMadeira.criarCarrinho();
        Brinquedo bonecaMadeira = fabricaMadeira.criarBoneca();
        
        carrinhoPlastico.play();
        bonecaPlastico.play();
        carrinhoMadeira.play();
        bonecaMadeira.play();
    }
}

