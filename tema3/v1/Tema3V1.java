class Segmento {
    private int tamanho;

    public Segmento(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }
}
class Reta extends Segmento {
    public Reta(int tamanho) {
        super(tamanho);
    }
}

public class Tema3V1 {
    public static void main(String[] args) {
        Reta reta = new Reta(500);
        System.out.println("Tamanho: " + reta.getTamanho() + " m");
    }
}
