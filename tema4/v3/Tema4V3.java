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
        try {
            new Moto(-10);
        } catch (IllegalArgumentException erro) {
            System.out.println("Cadastro rejeitado");
        } finally {
            System.out.println("Tentativa encerrada");
        }
        System.out.println("Proxima entrada");
    }
}
