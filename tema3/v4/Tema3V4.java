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

public class Tema3V4 {
    public static void main(String[] args) {
        LimitaVelocidade[] percurso = {
            new Reta(500),
            new CurvaTranquila(120),
            new QuebraMola(10)
        };

        for (int i = 0; i < percurso.length; i++) {
            int limite = percurso[i].getVelocidadeMaxima();
            System.out.println("Trecho " + (i + 1) + ": " + limite + " km/h");
        }
    }
}
