import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Moto {
    private int id;
    private String nome;
    private int velocidade;
    Moto(int id, String nome, int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("Velocidade negativa");
        }
        this.id = id;
        this.nome = nome;
        this.velocidade = velocidade;
    }
    int getId() { return id; }
    String getNome() { return nome; }
    int getVelocidade() { return velocidade; }
}
class MotoDAO {
    private Connection conexao;
    MotoDAO(Connection conexao) { this.conexao = conexao; }
    void criarTabela() throws SQLException {
        try (Statement comando = conexao.createStatement()) {
            comando.executeUpdate("CREATE TABLE moto ("
                + "id INT PRIMARY KEY, nome VARCHAR(60), "
                + "velocidade INT CHECK (velocidade >= 0))");
        }
    }
    void salvar(Moto moto) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(
                "INSERT INTO moto VALUES (?, ?, ?)")) {
            comando.setInt(1, moto.getId());
            comando.setString(2, moto.getNome());
            comando.setInt(3, moto.getVelocidade());
            comando.executeUpdate();
        }
    }
    Moto buscar(int id) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(
                "SELECT id, nome, velocidade FROM moto WHERE id = ?")) {
            comando.setInt(1, id);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    return new Moto(resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getInt("velocidade"));
                }
                return null;
            }
        }
    }
}
public class Tema6V5 {
    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(
                "jdbc:h2:mem:motos", "sa", "")) {
            MotoDAO dao = new MotoDAO(conexao);
            dao.criarTabela();
            dao.salvar(new Moto(1, "Moto A", 60));
            Moto encontrada = dao.buscar(1);
            if (encontrada != null) {
                System.out.println(encontrada.getNome() + " "
                    + encontrada.getVelocidade());
            }
        } catch (SQLException erro) {
            System.out.println("Falha SQL: " + erro.getMessage());
        }
    }
}
