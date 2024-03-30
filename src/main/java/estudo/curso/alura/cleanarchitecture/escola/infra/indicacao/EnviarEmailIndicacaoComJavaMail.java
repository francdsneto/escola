package estudo.curso.alura.cleanarchitecture.escola.infra.indicacao;

import estudo.curso.alura.cleanarchitecture.escola.dominio.indicacao.iEnviarEmailIndicacao;
import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements iEnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        // logica de envio de e-mail com a lib java mail
    }
}
