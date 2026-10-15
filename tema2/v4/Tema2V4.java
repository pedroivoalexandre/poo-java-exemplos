import java.util.Set;
import java.util.HashSet;
final class Moto {
    private final String placa;
    Moto(String placa) { this.placa = placa; }
    @Override
    public String toString() { return "Moto " + placa; }
    @Override
    public boolean equals(Object outro) {
        if (this == outro) return true;
        if (!(outro instanceof Moto)) return false;
        Moto moto = (Moto) outro;
        return placa.equals(moto.placa);
    }
    @Override
    public int hashCode() { return placa.hashCode(); }
}
public class Tema2V4 {
    public static void main(String[] args) {
        Set<Moto> motos = new HashSet<Moto>();
        System.out.println(motos.add(new Moto("ABC1D23")));
        System.out.println(motos.add(new Moto("ABC1D23")));
        System.out.println(motos.size());
    }
}
