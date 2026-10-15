package especial;
import modelo.Segmento;
public class Reta extends Segmento {
    public Reta(int tamanho) { super(tamanho); }
    public int consultar(Reta outra) {
        return this.tamanhoInterno() + outra.tamanhoInterno();
    }
    // base.tamanhoInterno() seria proibido se base fosse Segmento.
}
