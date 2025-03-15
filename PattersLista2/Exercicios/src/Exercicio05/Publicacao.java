/*Exercício 5: Sistema de Publicação de Conteúdo */

package Exercicio05;

class Publicacao {
    protected String titulo;
    protected String autor;
    protected String descricao;

    public Publicacao(String titulo, String autor, String descricao) {
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
    }

    public String exibirResumo() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nDescrição: " + descricao;
    }
}

class Artigo extends Publicacao {
    private int numeroDePalavras;

    public Artigo(String titulo, String autor, String descricao, int numeroDePalavras) {
        super(titulo, autor, descricao);
        this.numeroDePalavras = numeroDePalavras;
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo() + "\nNúmero de palavras: " + numeroDePalavras;
    }
}

class Video extends Publicacao {
    private int duracao;

    public Video(String titulo, String autor, String descricao, int duracao) {
        super(titulo, autor, descricao);
        this.duracao = duracao;
    }

    @Override
    public String exibirResumo() {
        return super.exibirResumo() + "\nDuração: " + duracao + " minutos";
    }
}

