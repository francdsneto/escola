package estudo.curso.alura.cleanarchitecture.escola.infra.aluno;

import estudo.curso.alura.cleanarchitecture.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements iRepositorioDeAlunos {

    private Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO ALUNO VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getCpf());
            preparedStatement.setString(3, aluno.getEmail());
            preparedStatement.execute();

            sql = "INSERT INTO TELEFONE VALUES(?,?)";
            preparedStatement = connection.prepareStatement(sql);

            for(Telefone telefone : aluno.getTelefones())
            {
                preparedStatement.setString(1, telefone.getDdd());
                preparedStatement.setString(2, telefone.getNumero());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {

        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cpf.getCpf());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if(!encontrou)
                throw new AlunoNaoEncontrado(cpf);

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno encontrado = new Aluno(nome, cpf, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);

            ps.setLong(1,id);
            rs = ps.executeQuery();
            while(rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.adicionarTelefone(ddd,numero);
            }

            return encontrado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {

        try {
            String sql = "SELECT id, nome, cpf, email FROM ALUNO";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while(rs.next())
            {
                String nome = rs.getString("nome");
                CPF cpf = new CPF(rs.getString("cpf"));
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(nome,cpf,email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                PreparedStatement ps2 = connection.prepareStatement(sql);
                ps2.setLong(1, id);
                ResultSet rs2 = ps2.executeQuery();
                while(rs.next()) {
                    String numero = rs2.getString("numero");
                    String ddd = rs2.getString("ddd");
                    aluno.adicionarTelefone(ddd,numero);
                }

                alunos.add(aluno);

            }
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
