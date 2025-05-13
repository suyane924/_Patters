package Exercicio01;

abstract class Aprovador {
    protected Aprovador proximo;

    public void setProximo(Aprovador proximo) {
        this.proximo = proximo;
    }

    public abstract void aprovarDespesa(double valor);
}

class Gerente extends Aprovador {
    @Override
    public void aprovarDespesa(double valor) {
        if (valor <= 1000) {
            System.out.println("Despesa de R$" + valor + " aprovada pelo Gerente.");
        } else if (proximo != null) {
            proximo.aprovarDespesa(valor);
        }
    }
}

class Diretor extends Aprovador {
    @Override
    public void aprovarDespesa(double valor) {
        if (valor <= 5000) {
            System.out.println("Despesa de R$" + valor + " aprovada pelo Diretor.");
        } else if (proximo != null) {
            proximo.aprovarDespesa(valor);
        }
    }
}

class VicePresidente extends Aprovador {
    @Override
    public void aprovarDespesa(double valor) {
        if (valor <= 20000) {
            System.out.println("Despesa de R$" + valor + " aprovada pelo Vice-Presidente.");
        } else if (proximo != null) {
            proximo.aprovarDespesa(valor);
        }
    }
}

class Presidente extends Aprovador {
    @Override
    public void aprovarDespesa(double valor) {
        System.out.println("Despesa de R$" + valor + " aprovada pelo Presidente.");
    }
}

public class SistemaAprovacao {
    public static void main(String[] args) {
        Aprovador gerente = new Gerente();
        Aprovador diretor = new Diretor();
        Aprovador vicePresidente = new VicePresidente();
        Aprovador presidente = new Presidente();

        gerente.setProximo(diretor);
        diretor.setProximo(vicePresidente);
        vicePresidente.setProximo(presidente);

        double[] despesas = {500, 3000, 10000, 30000};

        for (double valor : despesas) {
            System.out.println("\nSolicitando aprovação para R$" + valor);
            gerente.aprovarDespesa(valor);
        }
    }
}
