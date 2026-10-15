class Moto {
    private int velocidadeDesejada;
    Moto(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("Velocidade negativa");
        }
        velocidadeDesejada = velocidade;
    }
}
public class Tema4V2 {
    public static void main(String[] args) {
        try {
            int v = Integer.parseInt("-10");
            new Moto(v);
        } catch (NumberFormatException erro) {
            System.out.println("Formato invalido");
        } catch (IllegalArgumentException erro) {
            System.out.println("Valor invalido");
        }
    }
}
