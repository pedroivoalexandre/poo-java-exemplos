import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tema6V1 {
    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(
                "jdbc:h2:mem:motos", "sa", "");
             Statement comando = conexao.createStatement()) {
            comando.executeUpdate("CREATE TABLE moto ("
                + "id INT PRIMARY KEY, nome VARCHAR(60), "
                + "velocidade INT CHECK (velocidade >= 0))");
            System.out.println("Tabela criada");
        } catch (SQLException erro) {
            System.out.println("Falha SQL: " + erro.getMessage());
        }
    }
}
