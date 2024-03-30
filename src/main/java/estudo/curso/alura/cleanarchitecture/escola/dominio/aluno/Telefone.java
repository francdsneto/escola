package estudo.curso.alura.cleanarchitecture.escola.dominio.aluno;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {

        if(ddd == null || !ddd.matches("\\d{3}"))
            throw new IllegalArgumentException("DDD inválido");

        if(numero == null || !numero.matches("^\\d[0-9]{8,9}$"))
            throw new IllegalArgumentException("Número inválido");

        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
