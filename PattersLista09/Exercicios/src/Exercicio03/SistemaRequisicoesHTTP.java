package Exercicio03;

class RequisicaoHttp {
    public String token;
    public boolean emCache;

    public RequisicaoHttp(String token, boolean emCache) {
        this.token = token;
        this.emCache = emCache;
    }
}

abstract class ManipuladorHttp {
    protected ManipuladorHttp proximo;

    public void setProximo(ManipuladorHttp proximo) {
        this.proximo = proximo;
    }

    public void processar(RequisicaoHttp requisicao) {
        if (executar(requisicao) && proximo != null) {
            proximo.processar(requisicao);
        }
    }

    protected abstract boolean executar(RequisicaoHttp requisicao);
}

class Autenticacao extends ManipuladorHttp {
    @Override
    protected boolean executar(RequisicaoHttp requisicao) {
        if (requisicao.token != null && requisicao.token.equals("valid_token")) {
            System.out.println("Autenticação bem-sucedida.");
            return true;
        } else {
            System.out.println("Autenticação falhou. Requisição bloqueada.");
            return false;
        }
    }
}

class Cache extends ManipuladorHttp {
    @Override
    protected boolean executar(RequisicaoHttp requisicao) {
        if (requisicao.emCache) {
            System.out.println("Requisição atendida pelo cache.");
            return false; 
        } else {
            System.out.println("Cache ausente. Prosseguindo...");
            return true;
        }
    }
}

class Compressao extends ManipuladorHttp {
    @Override
    protected boolean executar(RequisicaoHttp requisicao) {
        System.out.println("Comprimindo conteúdo da resposta...");
        return true;
    }
}

class Logging extends ManipuladorHttp {
    @Override
    protected boolean executar(RequisicaoHttp requisicao) {
        System.out.println("Log: Requisição processada com sucesso.");
        return true;
    }
}

public class SistemaRequisicoesHTTP {
    public static void main(String[] args) {
        ManipuladorHttp auth = new Autenticacao();
        ManipuladorHttp cache = new Cache();
        ManipuladorHttp compressao = new Compressao();
        ManipuladorHttp logging = new Logging();

        auth.setProximo(cache);
        cache.setProximo(compressao);
        compressao.setProximo(logging);

        System.out.println("🔹 Requisição 1:");
        RequisicaoHttp req1 = new RequisicaoHttp("valid_token", false);
        auth.processar(req1);

        System.out.println("\n🔹 Requisição 2:");
        RequisicaoHttp req2 = new RequisicaoHttp("invalid_token", false);
        auth.processar(req2);

        System.out.println("\n🔹 Requisição 3:");
        RequisicaoHttp req3 = new RequisicaoHttp("valid_token", true);
        auth.processar(req3);
    }
}
