public class Tema4V1 {
    public static void main(String[] args) {
        try {
            int velocidade = Integer.parseInt("rapida");
            System.out.println(velocidade);
        } catch (NumberFormatException erro) {
            System.out.println("Informe um inteiro.");
        }
        System.out.println("Cadastro continua.");
    }
}
