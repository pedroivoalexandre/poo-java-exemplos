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
public class Tema2V2 {
    public static void main(String[] args) {
        Moto a = new Moto("ABC1D23");
        Moto b = new Moto("ABC1D23");
        System.out.println(a);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
    }
}
