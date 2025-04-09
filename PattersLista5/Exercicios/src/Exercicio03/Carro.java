// Exercício 3: Configuração de carros em uma concessionária

package Exercicio03;

class Carro {
    String modelo;
    String motor;
    String cor;
    String cambio;
    boolean tetoSolar;
    boolean somPremium;
    boolean bancosCouro;

    @Override
    public String toString() {
        return "Carro: Modelo=" + modelo + ", Motor=" + motor +
                (cor != null ? ", Cor=" + cor : "") +
                (cambio != null ? ", Câmbio=" + cambio : "") +
                (tetoSolar ? ", Teto Solar" : "") +
                (somPremium ? ", Som Premium" : "") +
                (bancosCouro ? ", Bancos de Couro" : "");
    }
}

class CarBuilder {
    private Carro carro = new Carro();
    private int opcionais = 0;

    public CarBuilder setModelo(String modelo) {
        carro.modelo = modelo;
        return this;
    }

    public CarBuilder setMotor(String motor) {
        carro.motor = motor;
        return this;
    }

    public CarBuilder setCor(String cor) {
        carro.cor = cor;
        return this;
    }

    public CarBuilder setCambio(String cambio) {
        carro.cambio = cambio;
        return this;
    }

    public CarBuilder addTetoSolar() {
        carro.tetoSolar = true;
        opcionais++;
        return this;
    }

    public CarBuilder addSomPremium() {
        carro.somPremium = true;
        opcionais++;
        return this;
    }

    public CarBuilder addBancosCouro() {
        carro.bancosCouro = true;
        opcionais++;
        return this;
    }

    public Carro build() {
        if (carro.modelo == null || carro.motor == null || opcionais < 2) {
            throw new IllegalStateException("É necessário definir modelo, motor e pelo menos dois opcionais.");
        }
        return carro;
    }
}

class CarDirector {
    public Carro criarCarroAutomaticoCompleto() {
        return new CarBuilder()
                .setModelo("SUV")
                .setMotor("Híbrido")
                .setCor("Preto")
                .setCambio("Automático")
                .addBancosCouro()
                .addSomPremium()
                .addTetoSolar()
                .build();
    }

    public Carro criarCarroManualSimples() {
        return new CarBuilder()
                .setModelo("Hatch")
                .setMotor("Gasolina")
                .setCor("Branco")
                .setCambio("Manual")
                .addSomPremium()
                .addBancosCouro()
                .build();
    }

    public Carro criarCarroEletricoPersonalizado() {
        return new CarBuilder()
                .setModelo("Sedan")
                .setMotor("Elétrico")
                .setCor("Azul")
                .setCambio("Automático")
                .addSomPremium()
                .addTetoSolar()
                .build();
    }
}

class MainCarro {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();

        System.out.println(director.criarCarroAutomaticoCompleto());
        System.out.println(director.criarCarroManualSimples());
        System.out.println(director.criarCarroEletricoPersonalizado());
    }
}
