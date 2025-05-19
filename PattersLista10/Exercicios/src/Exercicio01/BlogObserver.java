package Exercicio01;

import java.util.ArrayList;
import java.util.List;

public class BlogObserver {

    interface Observer {
        void update(String articleTitle, String comment);
    }

    static class User implements Observer {
        private String nome;

        public User(String nome) {
            this.nome = nome;
        }

        @Override
        public void update(String articleTitle, String comment) {
            System.out.println("[" + nome + "] Novo comentário em \"" + articleTitle + "\": " + comment);
        }

        public String getNome() {
            return nome;
        }
    }

    static class Article {
        private String titulo;
        private List<Observer> observadores = new ArrayList<>();
        private List<String> comentarios = new ArrayList<>();

        public Article(String titulo) {
            this.titulo = titulo;
        }

        public void inscrever(Observer observer) {
            observadores.add(observer);
            System.out.println(((User) observer).getNome() + " se inscreveu no artigo \"" + titulo + "\"");
        }

        public void cancelarInscricao(Observer observer) {
            observadores.remove(observer);
            System.out.println(((User) observer).getNome() + " cancelou a inscrição no artigo \"" + titulo + "\"");
        }

        public void adicionarComentario(String comentario) {
            comentarios.add(comentario);
            notificarObservadores(comentario);
        }

        private void notificarObservadores(String comentario) {
            for (Observer o : observadores) {
                o.update(titulo, comentario);
            }
        }
    }
    public static void main(String[] args) {
        Article artigo = new Article("Como usar o padrão Observer");

        User ana = new User("Ana");
        User bruno = new User("Bruno");

        artigo.inscrever(ana);
        artigo.inscrever(bruno);

        artigo.adicionarComentario("Ótimo artigo! Me ajudou bastante.");

        artigo.cancelarInscricao(bruno);

        artigo.adicionarComentario("Tenho uma dúvida sobre o exemplo.");
    }
}

