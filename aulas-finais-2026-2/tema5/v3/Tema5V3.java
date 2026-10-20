class Moto implements Runnable {
    private String nome;
    Moto(String nome) {
        this.nome = nome;
    }
    @Override
    public void run() {
        try {
            for (int trecho = 1; trecho <= 3; trecho++) {
                Thread.sleep(50);
                System.out.println(nome + ": trecho " + trecho);
            }
        } catch (InterruptedException erro) {
            Thread.currentThread().interrupt();
            System.out.println(nome + ": interrompida");
        }
    }
}
public class Tema5V3 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Moto("A"));
        a.start();
        a.join();
        System.out.println("Fim");
    }
}
