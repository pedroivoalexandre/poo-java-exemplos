public class Tema4V1 {
    public static void main(String[] args) {
        String[] entradas = {"60", "rapida", "40"};
        for (int i = 0; i < entradas.length; i++) {
            try {
                int v = Integer.parseInt(entradas[i]);
                System.out.println("Velocidade: " + v);
            } catch (NumberFormatException erro) {
                System.out.println("Formato invalido");
            }
        }
    }
}
