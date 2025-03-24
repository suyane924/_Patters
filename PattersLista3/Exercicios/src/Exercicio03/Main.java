package Exercicio03;

public class Main {
    public static void main(String[] args) {
        try {
            Media audio = MediaFactory.createMedia("audio");
            audio.play();
            audio.stop();
            
            Media video = MediaFactory.createMedia("video");
            video.play();
            video.stop();
            
            Media podcast = MediaFactory.createMedia("podcast");
            podcast.play();
            podcast.stop();
            
            // Teste com tipo inválido
            Media invalid = MediaFactory.createMedia("livestream");
            invalid.play();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
