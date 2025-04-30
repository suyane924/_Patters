package Exercicio01;

interface MediaAPI {
    void play();
    void pause();
    void stop();
}

class BasicAPI implements MediaAPI {
    public void play() {
        System.out.println("BasicAPI: Play (qualidade padrão)");
    }

    public void pause() {
        System.out.println("BasicAPI: Pause");
    }

    public void stop() {
        System.out.println("BasicAPI: Stop");
    }
}

class PremiumAPI implements MediaAPI {
    public void play() {
        System.out.println("PremiumAPI: Play com qualidade HD e streaming rápido");
    }

    public void pause() {
        System.out.println("PremiumAPI: Pause com sincronização em nuvem");
    }

    public void stop() {
        System.out.println("PremiumAPI: Stop e salvar posição");
    }
}

class ProfessionalAPI implements MediaAPI {
    public void play() {
        System.out.println("ProfessionalAPI: Play com qualidade máxima e ferramentas profissionais");
    }

    public void pause() {
        System.out.println("ProfessionalAPI: Pause com análise de frame");
    }

    public void stop() {
        System.out.println("ProfessionalAPI: Stop com logging detalhado");
    }
}

abstract class MediaPlayer {
    protected MediaAPI api;

    public MediaPlayer(MediaAPI api) {
        this.api = api;
    }

    public abstract void play();
    public abstract void pause();
    public abstract void stop();
}

class MusicPlayer extends MediaPlayer {
    public MusicPlayer(MediaAPI api) {
        super(api);
    }

    public void play() {
        System.out.println("MusicPlayer:");
        api.play();
    }

    public void pause() {
        System.out.println("MusicPlayer:");
        api.pause();
    }

    public void stop() {
        System.out.println("MusicPlayer:");
        api.stop();
    }
}

class VideoPlayer extends MediaPlayer {
    public VideoPlayer(MediaAPI api) {
        super(api);
    }

    public void play() {
        System.out.println("VideoPlayer:");
        api.play();
    }

    public void pause() {
        System.out.println("VideoPlayer:");
        api.pause();
    }

    public void stop() {
        System.out.println("VideoPlayer:");
        api.stop();
    }
}

class PodcastPlayer extends MediaPlayer {
    public PodcastPlayer(MediaAPI api) {
        super(api);
    }

    public void play() {
        System.out.println("PodcastPlayer:");
        api.play();
    }

    public void pause() {
        System.out.println("PodcastPlayer:");
        api.pause();
    }

    public void stop() {
        System.out.println("PodcastPlayer:");
        api.stop();
    }
}

class AudiobookPlayer extends MediaPlayer {
    public AudiobookPlayer(MediaAPI api) {
        super(api);
    }

    public void play() {
        System.out.println("AudiobookPlayer: Iniciando leitura com marcador de posição");
        api.play();
    }

    public void pause() {
        System.out.println("AudiobookPlayer: Pausando e salvando progresso");
        api.pause();
    }

    public void stop() {
        System.out.println("AudiobookPlayer: Parando e marcando como 'não finalizado'");
        api.stop();
    }
}

public class Reprodutores {
    public static void main(String[] args) {
        MediaAPI basicAPI = new BasicAPI();
        MediaAPI premiumAPI = new PremiumAPI();

        MediaPlayer musicPlayer = new MusicPlayer(basicAPI);
        MediaPlayer videoPlayer = new VideoPlayer(premiumAPI);
        MediaPlayer audiobookPlayer = new AudiobookPlayer(basicAPI);

        musicPlayer.play();
        videoPlayer.pause();
        audiobookPlayer.stop();
    }
}
