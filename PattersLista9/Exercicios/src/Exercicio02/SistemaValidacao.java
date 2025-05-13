package Exercicio02;

class Formulario {
    public String email;
    public String senha;

    public Formulario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}

abstract class Validador {
    protected Validador proximo;

    public void setProximo(Validador proximo) {
        this.proximo = proximo;
    }

    public void validar(Formulario form) {
        if (executarValidacao(form) && proximo != null) {
            proximo.validar(form);
        }
    }

    protected abstract boolean executarValidacao(Formulario form);
}

class ValidadorEmail extends Validador {
    @Override
    protected boolean executarValidacao(Formulario form) {
        if (form.email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            return true;
        } else {
            System.out.println("Erro: Email inválido.");
            return false;
        }
    }
}

class ValidadorSenha extends Validador {
    @Override
    protected boolean executarValidacao(Formulario form) {
        if (form.senha.length() >= 6) {
            return true;
        } else {
            System.out.println("Erro: A senha deve ter no mínimo 6 caracteres.");
            return false;
        }
    }
}

public class SistemaValidacao {
    public static void main(String[] args) {
        Validador validadorEmail = new ValidadorEmail();
        Validador validadorSenha = new ValidadorSenha();
        validadorEmail.setProximo(validadorSenha);

        System.out.println("Validação do formulário 1:");
        Formulario form1 = new Formulario("usuario@email.com", "123456");
        validadorEmail.validar(form1);

        System.out.println("\nValidação do formulário 2:");
        Formulario form2 = new Formulario("email_invalido", "123456");
        validadorEmail.validar(form2);

        System.out.println("\nValidação do formulário 3:");
        Formulario form3 = new Formulario("teste@exemplo.com", "123");
        validadorEmail.validar(form3);
    }
}
