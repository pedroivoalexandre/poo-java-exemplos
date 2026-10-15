class Segmento {
    private int tamanho;
    Segmento(int tamanho) { this.tamanho = tamanho; }
    protected int getTamanhoInterno() { return tamanho; }
    public int getVelocidadeMaxima() { return 80; }
}
class Reta extends Segmento {
    Reta(int tamanho) { super(tamanho); }
    public int comprimento() { return getTamanhoInterno(); }
    @Override
    public int getVelocidadeMaxima() { return 100; }
}
public class Tema2V1 {
    public static void main(String[] args) {
        Segmento trecho = new Reta(500);
        System.out.println(trecho.getVelocidadeMaxima());
        System.out.println(new Reta(500).comprimento());
    }
}
