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
class QuebraMola extends Segmento {
    public QuebraMola(int tamanho) {
        super(tamanho);
    }

    @Override
    public int getVelocidadeMaxima() {
        return 20;
    }
}
@FunctionalInterface
interface AvisoTrecho {
    String gerar(int limite);
}

public class Tema3V5 {
    public static void main(String[] args) {
        AvisoTrecho aviso = limite ->
            "Velocidade permitida: " + limite + " km/h";
        System.out.println(aviso.gerar(60));
    }
}
