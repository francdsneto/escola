package estudo.curso.alura.cleanarchitecture.escola;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.Aluno;
import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.CPF;
import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.Email;
import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.iRepositorioDeAlunos;
import estudo.curso.alura.cleanarchitecture.escola.infra.aluno.RepositorioAlunosEmMemoria;

public class MatricularAluno {

    public static void main(String[] args) {
        String nome = "Fulano da silva";
        CPF cpf = new CPF("123.123.123-12");
        Email email = new Email("email@email.com");

        Aluno aluno = new Aluno(nome, cpf, email);

        iRepositorioDeAlunos repositorio = new RepositorioAlunosEmMemoria();
        repositorio.matricular(aluno);

    }

}
