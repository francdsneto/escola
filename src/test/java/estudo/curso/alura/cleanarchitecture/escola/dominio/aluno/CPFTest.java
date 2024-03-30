package estudo.curso.alura.cleanarchitecture.escola.dominio.aluno;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.CPF;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    @DisplayName("Deve criar o CPF pois o valor é válido")
    void criaCPF() {

        var cpf = "123.123.123-12";
        assertDoesNotThrow(() -> new CPF(cpf));

    }

    @Test
    @DisplayName("Não deve criar o CPF pois o valor é inválido")
    void naoCriaCPF() {

        var cpf = "123.123.123-1";
        assertThrows(IllegalArgumentException.class, () -> new CPF(cpf));

    }

    @Test
    @DisplayName("Não deve criar o CPF pois o valor é nulo ou vazio")
    void naoCriaCPF2() {

        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));

    }
}