/*Criação de criaturas fantásticas*/

package Exercicio02;

interface Criatura {
    void attack();
}

class Dragao implements Criatura {
    @Override
    public void attack() {
        System.out.println("O Dragão cospe chamas ardentes!");
    }
}

class Salamandra implements Criatura {
    @Override
    public void attack() {
        System.out.println("A Salamandra se move rapidamente e lança uma explosão de fogo!");
    }
}

class SerpenteMarinha implements Criatura {
    @Override
    public void attack() {
        System.out.println("A Serpente Marinha ataca com suas ondas poderosas!");
    }
}

class Tritao implements Criatura {
    @Override
    public void attack() {
        System.out.println("O Tritão lança jatos de água afiados!");
    }
}
interface FabricaCriatura {
    Criatura criarCriaturaForte();
    Criatura criarCriaturaVeloz();
}

class FabricaReinoFogo implements FabricaCriatura {
    @Override
    public Criatura criarCriaturaForte() {
        return new Dragao();
    }
    
    @Override
    public Criatura criarCriaturaVeloz() {
        return new Salamandra();
    }
}

class FabricaReinoAgua implements FabricaCriatura {
    @Override
    public Criatura criarCriaturaForte() {
        return new SerpenteMarinha();
    }
    
    @Override
    public Criatura criarCriaturaVeloz() {
        return new Tritao();
    }
}
