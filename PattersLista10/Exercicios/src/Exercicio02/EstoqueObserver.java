package Exercicio02;

import java.util.*;

public class EstoqueObserver {

    enum TipoNotificacao {
        ESTOQUE_BAIXO, REABASTECIMENTO, ESGOTADO
    }

    interface Observador {
        void notificar(String produto, TipoNotificacao tipo, int quantidadeAtual);
        Set<TipoNotificacao> getTiposDeInteresse();
    }

    static class Produto {
        private String nome;
        private int quantidade;
        private int limiteMinimo;
        private Map<Observador, Set<TipoNotificacao>> observadores = new HashMap<>();

        public Produto(String nome, int quantidadeInicial, int limiteMinimo) {
            this.nome = nome;
            this.quantidade = quantidadeInicial;
            this.limiteMinimo = limiteMinimo;
        }

        public void inscrever(Observador obs) {
            observadores.put(obs, obs.getTiposDeInteresse());
        }

        public void cancelarInscricao(Observador obs) {
            observadores.remove(obs);
        }

        public void alterarEstoque(int novaQuantidade) {
            int quantidadeAnterior = quantidade;
            quantidade = novaQuantidade;

            if (quantidade == 0 && quantidadeAnterior > 0) {
                notificarObservadores(TipoNotificacao.ESGOTADO);
            } else if (quantidade < limiteMinimo && quantidadeAnterior >= limiteMinimo) {
                notificarObservadores(TipoNotificacao.ESTOQUE_BAIXO);
            } else if (quantidade >= limiteMinimo && quantidadeAnterior < limiteMinimo) {
                notificarObservadores(TipoNotificacao.REABASTECIMENTO);
            }
        }

        private void notificarObservadores(TipoNotificacao tipo) {
            for (Map.Entry<Observador, Set<TipoNotificacao>> entry : observadores.entrySet()) {
                if (entry.getValue().contains(tipo)) {
                    entry.getKey().notificar(nome, tipo, quantidade);
                }
            }
        }
    }
    static class DepartamentoVendas implements Observador {
        @Override
        public void notificar(String produto, TipoNotificacao tipo, int quantidade) {
            if (tipo == TipoNotificacao.ESTOQUE_BAIXO)
                System.out.println("[Vendas] Atenção: estoque baixo de " + produto + " (" + quantidade + " unidades)");
        }

        public Set<TipoNotificacao> getTiposDeInteresse() {
            return Set.of(TipoNotificacao.ESTOQUE_BAIXO);
        }
    }

    static class DepartamentoCompras implements Observador {
        @Override
        public void notificar(String produto, TipoNotificacao tipo, int quantidade) {
            if (tipo == TipoNotificacao.ESTOQUE_BAIXO || tipo == TipoNotificacao.ESGOTADO)
                System.out.println("[Compras] Precisa reabastecer " + produto + " (atual: " + quantidade + ")");
        }

        public Set<TipoNotificacao> getTiposDeInteresse() {
            return Set.of(TipoNotificacao.ESTOQUE_BAIXO, TipoNotificacao.ESGOTADO);
        }
    }

    static class Gerencia implements Observador {
        @Override
        public void notificar(String produto, TipoNotificacao tipo, int quantidade) {
            System.out.println("[Gerência] Notificação (" + tipo + ") para o produto: " + produto + " (estoque: " + quantidade + ")");
        }

        public Set<TipoNotificacao> getTiposDeInteresse() {
            return Set.of(TipoNotificacao.ESTOQUE_BAIXO, TipoNotificacao.ESGOTADO, TipoNotificacao.REABASTECIMENTO);
        }
    }

    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz 5kg", 20, 10);

        DepartamentoVendas vendas = new DepartamentoVendas();
        DepartamentoCompras compras = new DepartamentoCompras();
        Gerencia gerencia = new Gerencia();

        arroz.inscrever(vendas);
        arroz.inscrever(compras);
        arroz.inscrever(gerencia);

        System.out.println("\n[Estoque muda para 9]");
        arroz.alterarEstoque(9); 

        System.out.println("\n[Estoque muda para 0]");
        arroz.alterarEstoque(0); 

        System.out.println("\n[Estoque reabastecido para 15]");
        arroz.alterarEstoque(15); 
    }
}
