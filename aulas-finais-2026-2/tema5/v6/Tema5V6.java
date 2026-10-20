class Placar {
    private int chegadas;
    synchronized void registrar() {
        chegadas++;
    }
    int getChegadas() {
        return chegadas;
    }
}
class Moto implements Runnable {
    private String nome;
    private Placar placar;
    Moto(String nome, Placar placar) {
        this.nome = nome;
        this.placar = placar;
    }
    @Override
    public void run() {
        for (int trecho = 1; trecho <= 3; trecho++) {
            System.out.println(nome + ": trecho " + trecho);
        }
        placar.registrar();
    }
}
public class Tema5V6 {
    public static void main(String[] args) throws InterruptedException {
        Placar placar = new Placar();
        Thread[] motos = new Thread[3];
        for (int i = 0; i < motos.length; i++) {
            motos[i] = new Thread(new Moto("Moto " + (i + 1), placar));
            motos[i].start();
        }
        for (int i = 0; i < motos.length; i++) {
            motos[i].join();
        }
        System.out.println("Chegadas: " + placar.getChegadas());
    }
}
