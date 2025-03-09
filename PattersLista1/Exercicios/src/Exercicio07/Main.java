package Exercicio07;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("João");

        Notificacao email = new EmailNotificacao();
        Notificacao sms = new SmsNotificacao();
        Notificacao push = new PushNotificacao();

        usuario.receberNotificacao(email, "Você tem uma nova mensagem no sistema!");
        usuario.receberNotificacao(sms, "Seu pedido foi enviado com sucesso!");
        usuario.receberNotificacao(push, "Você recebeu uma nova curtida em sua foto!");
    }
}

