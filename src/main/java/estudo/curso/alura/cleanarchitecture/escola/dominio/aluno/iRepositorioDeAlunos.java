package estudo.curso.alura.cleanarchitecture.escola.dominio.aluno;

import java.util.List;

public interface iRepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();

}
