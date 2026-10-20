class Placar {
    private int passagens;
    synchronized void registrar() {
        passagens++;
    }
    int getPassagens() {
        return passagens;
    }
}
class Moto implements Runnable {
    private Placar placar;
    Moto(Placar placar) {
        this.placar = placar;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            placar.registrar();
        }
    }
}
public class Tema5V5 {
    public static void main(String[] args) throws InterruptedException {
        Placar placar = new Placar();
        Thread a = new Thread(new Moto(placar));
        Thread b = new Thread(new Moto(placar));
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(placar.getPassagens());
    }
}
