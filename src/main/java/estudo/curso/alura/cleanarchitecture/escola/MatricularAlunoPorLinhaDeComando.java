package estudo.curso.alura.cleanarchitecture.escola;

import estudo.curso.alura.cleanarchitecture.escola.aplicacao.aluno.matricular.MatricularAluno;
import estudo.curso.alura.cleanarchitecture.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import estudo.curso.alura.cleanarchitecture.escola.infra.aluno.RepositorioAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Fulano da silva";
        String cpf = "123.123.123-12";
        String email = "email@email.com";

        var matricular = new MatricularAluno(new RepositorioAlunosEmMemoria());
        matricular.executar(new MatricularAlunoDTO(nome,cpf,email));

    }

}
