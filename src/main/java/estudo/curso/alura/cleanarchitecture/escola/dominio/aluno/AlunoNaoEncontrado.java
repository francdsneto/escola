package estudo.curso.alura.cleanarchitecture.escola.dominio.aluno;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Um aluno não foi encontrado através do CPF informado: "+cpf.getCpf());
    }
}
