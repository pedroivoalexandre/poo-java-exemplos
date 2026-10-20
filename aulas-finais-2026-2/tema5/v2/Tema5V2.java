class Moto implements Runnable {
    private String nome;
    Moto(String nome) {
        this.nome = nome;
    }
    @Override
    public void run() {
        for (int trecho = 1; trecho <= 3; trecho++) {
            System.out.println(nome + ": trecho " + trecho);
        }
    }
}
public class Tema5V2 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Moto("A"));
        Thread b = new Thread(new Moto("B"));
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("Percurso encerrado");
    }
}
