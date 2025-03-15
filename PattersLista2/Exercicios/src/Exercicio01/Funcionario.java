/*Exercício 1: Sistema de Gerenciamento de Funcionários */

package Exercicio01;

public class Funcionario {
    protected String nome;
    protected double salario;
    protected String cargo;

    public Funcionario(String nome, double salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public double calcularVencimentos() {
        return salario;
    }
}

class FuncionarioEfetivo extends Funcionario {
    private double bonusAnual;

    public FuncionarioEfetivo(String nome, double salario, String cargo, double bonusAnual) {
        super(nome, salario, cargo);
        this.bonusAnual = bonusAnual;
    }

    @Override
    public double calcularVencimentos() {
        return salario + bonusAnual;
    }
}

class FuncionarioTerceirizado extends Funcionario {
    private double custoPorProjeto;

    public FuncionarioTerceirizado(String nome, double salario, String cargo, double custoPorProjeto) {
        super(nome, salario, cargo);
        this.custoPorProjeto = custoPorProjeto;
    }

    @Override
    public double calcularVencimentos() {
        return salario + custoPorProjeto;
    }
}
