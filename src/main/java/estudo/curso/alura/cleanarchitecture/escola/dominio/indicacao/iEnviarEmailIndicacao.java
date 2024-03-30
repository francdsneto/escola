package estudo.curso.alura.cleanarchitecture.escola.dominio.indicacao;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.Aluno;

public interface iEnviarEmailIndicacao {

    void enviarPara(Aluno indicado);

}
