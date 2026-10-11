interface LimitaVelocidade {
    int getVelocidadeMaxima();
}

class Segmento implements LimitaVelocidade {
    private int tamanho;

    public Segmento(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public int getVelocidadeMaxima() {
        return 80;
    }

    public int getTamanho() {
        return tamanho;
    }
}
class Reta extends Segmento {
    public Reta(int tamanho) {
        super(tamanho);
    }

    @Override
    public int getVelocidadeMaxima() {
        return 100;
    }
}
class CurvaTranquila extends Segmento {
    public CurvaTranquila(int tamanho) {
        super(tamanho);
    }

    @Override
    public int getVelocidadeMaxima() {
        return 60;
    }
}

public class Tema3V3 {
    public static void main(String[] args) {
        LimitaVelocidade trecho = new Segmento(500);
        System.out.println("Contrato atendido");
        System.out.println("Limite: " + trecho.getVelocidadeMaxima() + " km/h");
    }
}
