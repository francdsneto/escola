package estudo.curso.alura.cleanarchitecture.escola.aplicacao.aluno.matricular;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.*;

public class MatricularAluno {

    private final iRepositorioDeAlunos repositorio;

    public MatricularAluno(iRepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    public void executar(MatricularAlunoDTO dados) {
        Aluno novo = new FabricaDeAluno().comNomeCPFEmail(dados.nome(),dados.cpf(),dados.email()).criar();
        repositorio.matricular(novo);
    }

}
