package estudo.curso.alura.cleanarchitecture.escola.dominio.aluno;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.Email;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    @DisplayName("Deve permitir criar um email com estrutura válida")
    void deveCriarOEmailValido() {

        assertDoesNotThrow(() -> new Email("email@email.com"));

    }

    @Test
    @DisplayName("Não deve permitir criar um email com estrutura inválida")
    void naoDeveDeixarCriarEmailInvalido() {

        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido@."));

    }

}