# Tema 6 — Banco de dados com JDBC

PEDRO IVO ALEXANDRE · POO em Java

[Apresentação](https://docs.google.com/presentation/d/1sDg5j4tE5G07VuEmQsymsE8BkwmDeSdIzE-JoISyHTM/edit?usp=drivesdk) · [Compilador Java](https://www.jdoodle.com/online-java-compiler-ide)

No JDoodle, adicionar a biblioteca Maven `com.h2database:h2:2.3.232`. O banco H2 em memória não conserva os dados ao terminar o processo.

Cada versão é independente: execute apenas um arquivo por vez. A classe pública aparece por último e contém main. Não combine classes Moto de versões diferentes no mesmo projeto.

Validação: revisão estática realizada; execução e integração online ainda pendentes nesta sessão por indisponibilidade do ambiente. Saídas abaixo são esperadas, não registros de execução.

## Tema6V1 — Conectar e criar a tabela

```java
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
```

Saída/efeito esperado:

```text
Tabela criada
Requer a biblioteca Maven com.h2database:h2:2.3.232.
```

## Tema6V2 — Inserir e consultar com parâmetros

```java
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
```

Saída/efeito esperado:

```text
1 Moto A 60
2 Moto B 40
```

## Tema6V3 — Atualizar e excluir registros

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tema6V3 {
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
    static int alterar(Connection conexao, int id, int v)
            throws SQLException {
        String sql = "UPDATE moto SET velocidade = ? WHERE id = ?";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, v);
            comando.setInt(2, id);
            return comando.executeUpdate();
        }
    }
    static int excluir(Connection conexao, int id) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(
                "DELETE FROM moto WHERE id = ?")) {
            comando.setInt(1, id);
            return comando.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(
                "jdbc:h2:mem:motos", "sa", "")) {
            criarTabela(conexao);
            inserir(conexao, 1, "Moto A", 60);
            inserir(conexao, 2, "Moto B", 40);
            System.out.println("Alteradas: " + alterar(conexao, 1, 80));
            System.out.println("Excluidas: " + excluir(conexao, 2));
            consultar(conexao);
        } catch (SQLException erro) {
            System.out.println("Falha SQL: " + erro.getMessage());
        }
    }
}
```

Saída/efeito esperado:

```text
Alteradas: 1
Excluidas: 1
1 Moto A 80
```

## Tema6V4 — Transação com falha e rollback

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tema6V4 {
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
    static int alterar(Connection conexao, int id, int v)
            throws SQLException {
        String sql = "UPDATE moto SET velocidade = ? WHERE id = ?";
        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setInt(1, v);
            comando.setInt(2, id);
            return comando.executeUpdate();
        }
    }
    static int excluir(Connection conexao, int id) throws SQLException {
        try (PreparedStatement comando = conexao.prepareStatement(
                "DELETE FROM moto WHERE id = ?")) {
            comando.setInt(1, id);
            return comando.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(
                "jdbc:h2:mem:motos", "sa", "")) {
            criarTabela(conexao);
            inserir(conexao, 1, "Moto A", 60);
            conexao.setAutoCommit(false);
            try {
                alterar(conexao, 1, 80);
                inserir(conexao, 1, "Duplicada", 40);
                conexao.commit();
                System.out.println("Transacao confirmada");
            } catch (SQLException erro) {
                conexao.rollback();
                System.out.println("Transacao desfeita");
            }
            consultar(conexao);
            conexao.commit();
        } catch (SQLException erro) {
            System.out.println("Falha SQL: " + erro.getMessage());
        }
    }
}
```

Saída/efeito esperado:

```text
Transacao desfeita
1 Moto A 60
A tabela e a carga inicial são criadas antes da transação didática.
```

## Tema6V5 — Separar o objeto e o acesso ao banco

```java
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
```

Saída/efeito esperado:

```text
Moto A 60
O DAO fecha comandos e resultados; main é dono da Connection e a fecha.
```
