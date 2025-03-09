package Exercicio07;

public class Usuario {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void receberNotificacao(Notificacao notificacao, String mensagem) {
        System.out.println("Notificação para " + nome + ":");
        notificacao.enviar(mensagem);
    }
}

