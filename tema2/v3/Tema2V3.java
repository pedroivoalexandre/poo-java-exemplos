import java.util.List;
import java.util.ArrayList;
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
public class Tema2V3 {
    public static void main(String[] args) {
        List<Segmento> percurso = new ArrayList<Segmento>();
        percurso.add(new Reta(500));
        percurso.add(new Segmento(120));
        for (int i = 0; i < percurso.size(); i++) {
            System.out.println(percurso.get(i).getVelocidadeMaxima());
        }
    }
}
