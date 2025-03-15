package Exercicio05;

public class Main {
    public static void main(String[] args) {
        Artigo artigo = new Artigo("Como programar em Java", "João", "Artigo sobre programação em Java", 1200);
        Video video = new Video("Tutorial de Java", "Maria", "Vídeo tutorial de Java para iniciantes", 15);

        System.out.println(artigo.exibirResumo());
        System.out.println();
        System.out.println(video.exibirResumo());
    }
}