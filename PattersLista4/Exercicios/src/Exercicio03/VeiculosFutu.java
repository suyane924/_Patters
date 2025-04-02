/*Personalização de veículos futuristas*/

package Exercicio03;
  

interface Propulsao {
    void ativar();
}

class MotorJato implements Propulsao {
    @Override
    public void ativar() {
        System.out.println("Ativando motor a jato!");
    }
}

class PropulsaoPlasma implements Propulsao {
    @Override
    public void ativar() {
        System.out.println("Ativando propulsão a plasma!");
    }
}

interface Controle {
    void operar();
}

class InteligenciaArtificial implements Controle {
    @Override
    public void operar() {
        System.out.println("Operando com inteligência artificial!");
    }
}

class ControleManual implements Controle {
    @Override
    public void operar() {
        System.out.println("Operando com controle manual!");
    }
}

interface VeiculoFuturista {
    void configurar();
}

class CarroVoador implements VeiculoFuturista {
    private Propulsao propulsao;
    private Controle controle;
    
    public CarroVoador(Propulsao propulsao, Controle controle) {
        this.propulsao = propulsao;
        this.controle = controle;
    }
    
    @Override
    public void configurar() {
        System.out.println("Configurando Carro Voador...");
        propulsao.ativar();
        controle.operar();
    }
}

class MotoAutonoma implements VeiculoFuturista {
    private Propulsao propulsao;
    private Controle controle;
    
    public MotoAutonoma(Propulsao propulsao, Controle controle) {
        this.propulsao = propulsao;
        this.controle = controle;
    }
    
    @Override
    public void configurar() {
        System.out.println("Configurando Moto Autônoma...");
        propulsao.ativar();
        controle.operar();
    }
}

class Nave implements VeiculoFuturista {
    private Propulsao propulsao;
    private Controle controle;
    
    public Nave(Propulsao propulsao, Controle controle) {
        this.propulsao = propulsao;
        this.controle = controle;
    }
    
    @Override
    public void configurar() {
        System.out.println("Configurando Nave Espacial...");
        propulsao.ativar();
        controle.operar();
    }
}

class ExploradorRobotico implements VeiculoFuturista {
    private Propulsao propulsao;
    private Controle controle;
    
    public ExploradorRobotico(Propulsao propulsao, Controle controle) {
        this.propulsao = propulsao;
        this.controle = controle;
    }
    
    @Override
    public void configurar() {
        System.out.println("Configurando Explorador Robótico...");
        propulsao.ativar();
        controle.operar();
    }
}

interface FabricaVeiculoFuturista {
    VeiculoFuturista criarVeiculo1();
    VeiculoFuturista criarVeiculo2();
}

class FabricaTerra implements FabricaVeiculoFuturista {
    @Override
    public VeiculoFuturista criarVeiculo1() {
        return new CarroVoador(new MotorJato(), new InteligenciaArtificial());
    }
    
    @Override
    public VeiculoFuturista criarVeiculo2() {
        return new MotoAutonoma(new MotorJato(), new ControleManual());
    }
}

class FabricaEspaco implements FabricaVeiculoFuturista {
    @Override
    public VeiculoFuturista criarVeiculo1() {
        return new Nave(new PropulsaoPlasma(), new InteligenciaArtificial());
    }
    
    @Override
    public VeiculoFuturista criarVeiculo2() {
        return new ExploradorRobotico(new PropulsaoPlasma(), new ControleManual());
    }
}

