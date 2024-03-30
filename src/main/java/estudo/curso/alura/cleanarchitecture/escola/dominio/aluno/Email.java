package estudo.curso.alura.cleanarchitecture.escola.dominio.aluno;

public class Email {

    /**
     * Se um endereco for igual a outro, se trata do mesmo objeto, mesma instância.
     *
     * Esse tipo de classe sem um atributo único se chama Value Object
     */

    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
