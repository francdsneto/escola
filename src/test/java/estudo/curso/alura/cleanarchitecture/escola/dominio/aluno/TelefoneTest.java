package estudo.curso.alura.cleanarchitecture.escola.dominio.aluno;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    @DisplayName("Deve criar o telefone pois o DDD e Número são válidos")
    void deveCriarOTelefoneCorretamente() {

        var ddd = "085";
        var numero = "999999999";

        assertDoesNotThrow(() -> new Telefone(ddd,numero));
    }

    @Test
    @DisplayName("Não deve criar o telefone pois o DDD é válido")
    void naoCriaTelefoneDDDInvalido() {

        var ddd = "a85";
        var numero = "999999999";

        assertThrows(IllegalArgumentException.class, () -> new Telefone(ddd,numero));
    }

    @Test
    @DisplayName("Não deve criar o telefone pois o número é válido")
    void naoCriaTelefoneNumeroInvalido() {

        var ddd = "085";
        var numero = "9999999";

        assertThrows(IllegalArgumentException.class, () -> new Telefone(ddd,numero));
    }

}