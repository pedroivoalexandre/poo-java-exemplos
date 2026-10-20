class Moto {
    private int velocidadeDesejada;
    Moto(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("Velocidade negativa");
        }
        velocidadeDesejada = velocidade;
    }
}
public class Tema4V3 {
    public static void main(String[] args) {
        String[] entradas = {"rapida", "-10", "60"};
        for (int i = 0; i < entradas.length; i++) {
            try {
                int v = Integer.parseInt(entradas[i]);
                new Moto(v);
                System.out.println("Cadastro aceito");
            } catch (NumberFormatException erro) {
                System.out.println("Formato invalido");
            } catch (IllegalArgumentException erro) {
                System.out.println("Valor invalido");
            } finally {
                System.out.println("Tentativa encerrada");
            }
        }
    }
}
