/*Exercício 1: Montagem de pedidos em um restaurante*/

package Exercicio01;

class BurgerOrder {
    String pao;
    String proteina;
    boolean queijo;
    boolean alface;
    boolean tomate;
    boolean cebola;
    boolean molhoEspecial;
    boolean bebida;

    @Override
    public String toString() {
        return "Pedido: Pão=" + pao + ", Proteína=" + proteina +
                (queijo ? ", Queijo" : "") +
                (alface ? ", Alface" : "") +
                (tomate ? ", Tomate" : "") +
                (cebola ? ", Cebola" : "") +
                (molhoEspecial ? ", Molho Especial" : "") +
                (bebida ? ", Bebida" : "");
    }
}

class BurgerOrderBuilder {
    private BurgerOrder order = new BurgerOrder();

    public BurgerOrderBuilder setPao(String pao) {
        order.pao = pao;
        return this;
    }

    public BurgerOrderBuilder setProteina(String proteina) {
        order.proteina = proteina;
        return this;
    }

    public BurgerOrderBuilder addQueijo() {
        order.queijo = true;
        return this;
    }

    public BurgerOrderBuilder addAlface() {
        order.alface = true;
        return this;
    }

    public BurgerOrderBuilder addTomate() {
        order.tomate = true;
        return this;
    }

    public BurgerOrderBuilder addCebola() {
        order.cebola = true;
        return this;
    }

    public BurgerOrderBuilder addMolhoEspecial() {
        order.molhoEspecial = true;
        return this;
    }

    public BurgerOrderBuilder adicionarBebida() {
        order.bebida = true;
        return this;
    }

    public BurgerOrder build() {
        return order;
    }
}

class BurgerDirector {
    public BurgerOrder criarSimplesSemTomate() {
        return new BurgerOrderBuilder()
                .setPao("Tradicional")
                .setProteina("Carne")
                .addQueijo()
                .addAlface()
                .addCebola()
                .addMolhoEspecial()
                .adicionarBebida()
                .build();
    }

    public BurgerOrder criarVegetarianoComBebida() {
        return new BurgerOrderBuilder()
                .setPao("Integral")
                .setProteina("Vegetariano")
                .addAlface()
                .addTomate()
                .addMolhoEspecial()
                .adicionarBebida()
                .build();
    }

    public BurgerOrder criarFrangoCompleto() {
        return new BurgerOrderBuilder()
                .setPao("Australiano")
                .setProteina("Frango")
                .addQueijo()
                .addAlface()
                .addTomate()
                .addCebola()
                .addMolhoEspecial()
                .adicionarBebida()
                .build();
    }
}

class Main {
    public static void main(String[] args) {
        BurgerDirector director = new BurgerDirector();

        System.out.println(director.criarSimplesSemTomate());
        System.out.println(director.criarVegetarianoComBebida());
        System.out.println(director.criarFrangoCompleto());
    }
}
