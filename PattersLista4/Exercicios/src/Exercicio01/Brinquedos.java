/*Faricação de brinquedos*/

package Exercicio01;

interface Brinquedo {
    void play();
}

class CarrinhoPlastico implements Brinquedo {
    @Override
    public void play() {
        System.out.println("Brincando com um carrinho de plástico!");
    }
}

class BonecaPlastico implements Brinquedo {
    @Override
    public void play() {
        System.out.println("Brincando com uma boneca de plástico!");
    }
}

class CarrinhoMadeira implements Brinquedo {
    @Override
    public void play() {
        System.out.println("Brincando com um carrinho de madeira!");
    }
}

class BonecaMadeira implements Brinquedo {
    @Override
    public void play() {
        System.out.println("Brincando com uma boneca de madeira!");
    }
}

interface FabricaBrinquedo {
    Brinquedo criarCarrinho();
    Brinquedo criarBoneca();
}

class FabricaPlastico implements FabricaBrinquedo {
    @Override
    public Brinquedo criarCarrinho() {
        return new CarrinhoPlastico();
    }
    
    @Override
    public Brinquedo criarBoneca() {
        return new BonecaPlastico();
    }
}

class FabricaMadeira implements FabricaBrinquedo {
    @Override
    public Brinquedo criarCarrinho() {
        return new CarrinhoMadeira();
    }
    
    @Override
    public Brinquedo criarBoneca() {
        return new BonecaMadeira();
    }
}

