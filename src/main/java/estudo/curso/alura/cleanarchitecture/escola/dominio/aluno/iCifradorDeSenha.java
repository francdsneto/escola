package estudo.curso.alura.cleanarchitecture.escola.dominio.aluno;

public interface iCifradorDeSenha {

    String cifrarSenha(String senha);
    boolean validarSenhaCifrada(String senhaCifrada, String senhaAberta);

}
