import java.io.IOException;
import java.io.StringReader;

public class Tema4V5 {
    public static void main(String[] args) {
        try (StringReader leitor = new StringReader("90")) {
            System.out.println(leitor.read());
        } catch (IOException erro) {
            System.out.println("Falha na leitura");
        }
    }
}
