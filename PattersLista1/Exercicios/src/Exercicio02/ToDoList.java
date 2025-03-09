package Exercicio02;
/*
EXERCICIO 02

Converta um código que gerencia uma lista de tarefas (to-do list) usando funções para uma versão orientada a objetos. */

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> tarefas;

    public ToDoList() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa \"" + tarefa + "\" adicionada.");
    }

    public void listarTarefas() {
        System.out.println("Lista de Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i));
        }
    }

    public void removerTarefa(int index) {
        if (index >= 0 && index < tarefas.size()) {
            String tarefaRemovida = tarefas.remove(index);
            System.out.println("Tarefa \"" + tarefaRemovida + "\" removida.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        todoList.adicionarTarefa("Estudar Java");
        todoList.adicionarTarefa("Fazer exercícios de POO");
        todoList.listarTarefas();
        todoList.removerTarefa(0);
        todoList.listarTarefas();
    }
}
