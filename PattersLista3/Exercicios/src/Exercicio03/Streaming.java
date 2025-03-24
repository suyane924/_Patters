/*Plataforma de Streaming */

package Exercicio03;

interface Media {
    void play();
    void stop();
}

class AudioMedia implements Media {
    @Override
    public void play() {
        System.out.println("Reproduzindo áudio...");
    }
    
    @Override
    public void stop() {
        System.out.println("Áudio parado.");
    }
}

class VideoMedia implements Media {
    @Override
    public void play() {
        System.out.println("Reproduzindo vídeo...");
    }
    
    @Override
    public void stop() {
        System.out.println("Vídeo parado.");
    }
}

class PodcastMedia implements Media {
    @Override
    public void play() {
        System.out.println("Reproduzindo podcast...");
    }
    
    @Override
    public void stop() {
        System.out.println("Podcast parado.");
    }
}

class MediaFactory {
    public static Media createMedia(String type) {
        if (type.equalsIgnoreCase("audio")) {
            return new AudioMedia();
        } else if (type.equalsIgnoreCase("video")) {
            return new VideoMedia();
        } else if (type.equalsIgnoreCase("podcast")) {
            return new PodcastMedia();
        } else {
            throw new IllegalArgumentException("Tipo de mídia desconhecido");
        }
    }
}