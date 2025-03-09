package Exercicio07;

/*
EXERCICIO 07

Sistema de Notificações
User Story: Como um usuário de um aplicativo, eu quero receber notificações por diferentes canais (e-mail, SMS, push notification), para que eu possa me manter informado sobre atividades importantes. */

public interface Notificacao {
    void enviar(String mensagem);
}

