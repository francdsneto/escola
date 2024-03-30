package estudo.curso.alura.cleanarchitecture.escola.infra.aluno;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.Aluno;
import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.AlunoNaoEncontrado;
import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.CPF;
import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.iRepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAlunosEmMemoria implements iRepositorioDeAlunos {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return matriculados.stream()
                            .filter(a -> a.getCpf().equals(cpf.getCpf()))
                            .findFirst()
                            .orElseThrow( () -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
