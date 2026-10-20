import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tema6V2 {
    static void criarTabela(Connection conexao) throws SQLException {
        try (Statement comando = conexao.createStatement()) {
            comando.executeUpdate("CREATE TABLE moto ("
                + "id INT PRIMARY KEY, nome VARCHAR(60), "
                + "velocidade INT CHECK (velocidade >= 0))");
        }
    }
    static void inserir(Connection conexao, int id, String nome, int v)
            throws SQLException {
        String sql = "INSERT INTO moto VALUES (?, ?, ?)";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, id);
            comando.setString(2, nome);
            comando.setInt(3, v);
            comando.executeUpdate();
        }
    }
    static void consultar(Connection conexao) throws SQLException {
        String sql = "SELECT id, nome, velocidade FROM moto ORDER BY id";
        try (PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {
            while (resultado.next()) {
                System.out.println(resultado.getInt("id") + " "
                    + resultado.getString("nome") + " "
                    + resultado.getInt("velocidade"));
            }
        }
    }

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(
                "jdbc:h2:mem:motos", "sa", "")) {
            criarTabela(conexao);
            inserir(conexao, 1, "Moto A", 60);
            inserir(conexao, 2, "Moto B", 40);
            consultar(conexao);
        } catch (SQLException erro) {
            System.out.println("Falha SQL: " + erro.getMessage());
        }
    }
}
