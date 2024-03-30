package estudo.curso.alura.cleanarchitecture.escola.aplicacao.aluno.matricular;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.Aluno;
import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.CPF;
import estudo.curso.alura.cleanarchitecture.escola.infra.aluno.RepositorioAlunosEmMemoria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    @DisplayName("Deve persistir o aluno")
    void alunoDeveriaSerPersistido() {
        RepositorioAlunosEmMemoria repositorio = new RepositorioAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        var dados = new MatricularAlunoDTO("fulano", "123.123.123-12", "fulano@email.com");
        useCase.executar(dados);

        Aluno aluno = repositorio.buscarPorCPF(new CPF("123.123.123-12"));
        assertEquals("fulano", aluno.getNome());
        assertEquals("123.123.123-12", aluno.getCpf());
        assertEquals("fulano@email.com", aluno.getEmail());
    }

}