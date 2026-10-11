class Segmento {
    private int tamanho;

    public Segmento(int tamanho) {
        this.tamanho = tamanho;
    }

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

public class Tema3V2 {
    public static void main(String[] args) {
        Segmento reta = new Reta(500);
        Segmento curva = new CurvaTranquila(120);
        System.out.println("Reta: " + reta.getVelocidadeMaxima() + " km/h");
        System.out.println("Curva: " + curva.getVelocidadeMaxima() + " km/h");
    }
}
