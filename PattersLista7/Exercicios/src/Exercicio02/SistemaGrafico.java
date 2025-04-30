package Exercicio02;

interface RenderPlatform {
    void render(String content);
}

class WindowsRenderer implements RenderPlatform {
    public void render(String content) {
        System.out.println("Renderizando no Windows: " + content);
    }
}

class LinuxRenderer implements RenderPlatform {
    public void render(String content) {
        System.out.println("Renderizando no Linux: " + content);
    }
}

class MacOSRenderer implements RenderPlatform {
    public void render(String content) {
        System.out.println("Renderizando no macOS: " + content);
    }
}

class AndroidRenderer implements RenderPlatform {
    public void render(String content) {
        System.out.println("Renderizando no Android: " + content);
    }
}

abstract class DrawingFormat {
    protected RenderPlatform renderer;

    public DrawingFormat(RenderPlatform renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}

class VectorDrawing extends DrawingFormat {
    public VectorDrawing(RenderPlatform renderer) {
        super(renderer);
    }

    public void draw() {
        renderer.render("Desenho vetorial com linhas e curvas");
    }
}

class BitmapDrawing extends DrawingFormat {
    public BitmapDrawing(RenderPlatform renderer) {
        super(renderer);
    }

    public void draw() {
        renderer.render("Desenho bitmap com pixels");
    }
}

class ThreeDDrawing extends DrawingFormat {
    public ThreeDDrawing(RenderPlatform renderer) {
        super(renderer);
    }

    public void draw() {
        renderer.render("Desenho 3D com modelagem de objetos");
    }
}

public class SistemaGrafico {
    public static void main(String[] args) {
        
        DrawingFormat bitmapOnLinux = new BitmapDrawing(new LinuxRenderer());
        bitmapOnLinux.draw();

        
        DrawingFormat vectorOnWindows = new VectorDrawing(new WindowsRenderer());
        vectorOnWindows.draw();

        
        DrawingFormat threeDOnMac = new ThreeDDrawing(new MacOSRenderer());
        threeDOnMac.draw();

        
        DrawingFormat threeDOnAndroid = new ThreeDDrawing(new AndroidRenderer());
        threeDOnAndroid.draw();
    }
}
