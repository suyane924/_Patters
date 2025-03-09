package Exercicio04;
/*
EXERCICIO 04

Gerenciamento de Tarefas Pessoais
User Story:
Como um usuário, eu quero poder adicionar tarefas pessoais, marcar tarefas como concluídas e visualizar minha lista de tarefas, para que eu possa organizar meu dia a dia. */

import java.util.ArrayList;
import java.util.List;

class Tarefa {
    String descricao;
        private boolean concluida;
    
        public Tarefa(String descricao) {
            this.descricao = descricao;
            this.concluida = false;
        }
    
        public void marcarConcluida() {
            this.concluida = true;
        }
    
        public void exibirDetalhes() {
            String status = concluida ? "Concluída" : "Pendente";
            System.out.println(descricao + " - " + status);
        }
    
        public boolean isConcluida() {
            return concluida;
        }
    }
    
    class GerenciadorTarefas {
        private List<Tarefa> listaTarefas;
    
        public GerenciadorTarefas() {
            this.listaTarefas = new ArrayList<>();
        }
    
        public void adicionarTarefa(String descricao) {
            Tarefa novaTarefa = new Tarefa(descricao);
            listaTarefas.add(novaTarefa);
            System.out.println("Tarefa adicionada: " + descricao);
        }
    
        public void marcarConcluida(int indice) {
            if (indice >= 0 && indice < listaTarefas.size()) {
                listaTarefas.get(indice).marcarConcluida();
                System.out.println("Tarefa marcada como concluída: " + listaTarefas.get(indice).descricao);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void exibirTarefas() {
        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (int i = 0; i < listaTarefas.size(); i++) {
                System.out.print((i + 1) + ". ");
                listaTarefas.get(i).exibirDetalhes();
            }
        }
    }
}

public class SistemaDeTarefas {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        gerenciador.adicionarTarefa("Ir ao mercado");
        gerenciador.adicionarTarefa("Estudar inglês");
        gerenciador.adicionarTarefa("Ler um livro");

        gerenciador.exibirTarefas();

        gerenciador.marcarConcluida(1);

        gerenciador.exibirTarefas();
    }
}
