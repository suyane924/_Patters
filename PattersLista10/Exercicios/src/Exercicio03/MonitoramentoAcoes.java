package Exercicio03;

import java.util.*;
import java.time.LocalDateTime;

enum TipoAlerta {
    PRECO, VOLUME, EVENTO_IMPORTANTE
}

enum Prioridade {
    ALTA, MEDIA, BAIXA
}

interface Observador {
    void notificar(Notificacao notificacao);
    boolean deveNotificar(Acao acao, TipoAlerta tipo, double valor);
}

class Notificacao {
    String acao;
    TipoAlerta tipo;
    double valor;
    Prioridade prioridade;
    LocalDateTime dataHora;

    public Notificacao(String acao, TipoAlerta tipo, double valor, Prioridade prioridade) {
        this.acao = acao;
        this.tipo = tipo;
        this.valor = valor;
        this.prioridade = prioridade;
        this.dataHora = LocalDateTime.now();
    }

    public String toString() {
        return "[" + prioridade + "] " + acao + " - " + tipo + ": " + valor + " às " + dataHora;
    }
}

interface FiltroNotificacao {
    boolean verificar(Acao acao, TipoAlerta tipo, double valor);
}

class FiltroPrecoMaiorQue implements FiltroNotificacao {
    private double limite;
    public FiltroPrecoMaiorQue(double limite) { this.limite = limite; }

    public boolean verificar(Acao acao, TipoAlerta tipo, double valor) {
        return tipo == TipoAlerta.PRECO && valor > limite;
    }
}

class FiltroVolumeMaiorQue implements FiltroNotificacao {
    private double limite;
    public FiltroVolumeMaiorQue(double limite) { this.limite = limite; }

    public boolean verificar(Acao acao, TipoAlerta tipo, double valor) {
        return tipo == TipoAlerta.VOLUME && valor > limite;
    }
}

class Acao {
    private String nome;
    private List<Observador> observadores = new ArrayList<>();

    public Acao(String nome) { this.nome = nome; }

    public void inscrever(Observador obs) {
        observadores.add(obs);
    }

    public void cancelarInscricao(Observador obs) {
        observadores.remove(obs);
    }

    public void atualizar(TipoAlerta tipo, double valor) {
        for (Observador obs : observadores) {
            if (obs.deveNotificar(this, tipo, valor)) {
                Prioridade prioridade = (tipo == TipoAlerta.EVENTO_IMPORTANTE) ? Prioridade.ALTA :
                                        (tipo == TipoAlerta.PRECO) ? Prioridade.MEDIA :
                                        Prioridade.BAIXA;

                Notificacao notif = new Notificacao(nome, tipo, valor, prioridade);
                obs.notificar(notif);
            }
        }
    }

    public String getNome() { return nome; }
}

class Investidor implements Observador {
    private String nome;
    private Map<Acao, List<FiltroNotificacao>> filtrosPorAcao = new HashMap<>();
    private List<Notificacao> historico = new ArrayList<>();

    public Investidor(String nome) {
        this.nome = nome;
    }

    public void adicionarFiltro(Acao acao, FiltroNotificacao filtro) {
        filtrosPorAcao.computeIfAbsent(acao, k -> new ArrayList<>()).add(filtro);
        acao.inscrever(this);
    }

    public boolean deveNotificar(Acao acao, TipoAlerta tipo, double valor) {
        List<FiltroNotificacao> filtros = filtrosPorAcao.get(acao);
        if (filtros == null) return false;
        for (FiltroNotificacao f : filtros) {
            if (f.verificar(acao, tipo, valor)) return true;
        }
        return false;
    }

    public void notificar(Notificacao notificacao) {
        historico.add(notificacao);
        System.out.println("[" + nome + "] recebeu: " + notificacao);
    }

    public void exibirHistorico() {
        System.out.println("\nHistórico de " + nome + ":");
        for (Notificacao n : historico) {
            System.out.println(n);
        }
    }
}

public class MonitoramentoAcoes {
    public static void main(String[] args) {
        Acao petrobras = new Acao("PETR4");
        Acao vale = new Acao("VALE3");

        Investidor joao = new Investidor("João");
        Investidor ana = new Investidor("Ana");

        joao.adicionarFiltro(petrobras, new FiltroPrecoMaiorQue(35.0));
        joao.adicionarFiltro(vale, new FiltroVolumeMaiorQue(1000000));

        ana.adicionarFiltro(petrobras, new FiltroVolumeMaiorQue(500000));
        ana.adicionarFiltro(vale, new FiltroPrecoMaiorQue(60.0));

        System.out.println("\n>>> Atualizações de mercado\n");

        petrobras.atualizar(TipoAlerta.PRECO, 36.5);
        vale.atualizar(TipoAlerta.VOLUME, 1200000);
        petrobras.atualizar(TipoAlerta.VOLUME, 600000);
        vale.atualizar(TipoAlerta.PRECO, 61.0);
        vale.atualizar(TipoAlerta.EVENTO_IMPORTANTE, 0);

        joao.exibirHistorico();
        ana.exibirHistorico();
    }
}
