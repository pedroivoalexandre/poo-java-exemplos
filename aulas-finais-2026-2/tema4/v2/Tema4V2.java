class Moto {
    private int velocidadeDesejada;
    Moto(int velocidade) {
        definirVelocidade(velocidade);
    }
    void definirVelocidade(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("Velocidade negativa");
        }
        velocidadeDesejada = velocidade;
    }
    int getVelocidadeDesejada() {
        return velocidadeDesejada;
    }
}
public class Tema4V2 {
    public static void main(String[] args) {
        Moto moto = new Moto(60);
        try {
            moto.definirVelocidade(-10);
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
        System.out.println(moto.getVelocidadeDesejada());
    }
}
