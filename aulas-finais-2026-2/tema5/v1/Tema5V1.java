class Moto {
    private String nome;
    Moto(String nome) {
        this.nome = nome;
    }
    void percorrer() {
        for (int trecho = 1; trecho <= 3; trecho++) {
            System.out.println(nome + ": trecho " + trecho);
        }
    }
}
public class Tema5V1 {
    public static void main(String[] args) {
        Moto a = new Moto("A");
        Moto b = new Moto("B");
        a.percorrer();
        b.percorrer();
    }
}
