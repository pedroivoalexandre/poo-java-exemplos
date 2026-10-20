# Tema 5 — Threads e concorrência

PEDRO IVO ALEXANDRE · POO em Java

[Apresentação](https://docs.google.com/presentation/d/1BVqQQpLwkhRjn5OHVuRTbrsMYDmQiWuNSyw_dkM5-q4/edit?usp=drivesdk) · [Compilador Java](https://www.jdoodle.com/online-java-compiler-ide)

Cada versão é independente: execute apenas um arquivo por vez. A classe pública aparece por último e contém main. Não combine classes Moto de versões diferentes no mesmo projeto.

Validação: revisão estática realizada; execução e integração online ainda pendentes nesta sessão por indisponibilidade do ambiente. Saídas abaixo são esperadas, não registros de execução.

## Tema5V1 — Execução sequencial

```java
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
```

Saída/efeito esperado:

```text
A: trecho 1
A: trecho 2
A: trecho 3
B: trecho 1
B: trecho 2
B: trecho 3
```

## Tema5V2 — Uma tarefa Runnable e duas threads

```java
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
```

Saída/efeito esperado:

```text
Uma saída possível; a intercalação pode mudar:
A: trecho 1
B: trecho 1
B: trecho 2
A: trecho 2
A: trecho 3
B: trecho 3
Percurso encerrado
```

## Tema5V3 — Pausa e interrupção cooperativa

```java
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
```

Saída/efeito esperado:

```text
A: trecho 1
A: trecho 2
A: trecho 3
Fim
Sem interrupção solicitada neste main. sleep não mede o tempo físico da moto.
```

## Tema5V4 — Estado compartilhado sem proteção

```java
class Placar {
    private int passagens;
    void registrar() {
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
public class Tema5V4 {
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
```

Saída/efeito esperado:

```text
Não há total garantido. 200000 é possível, mas atualizações podem ser perdidas. Uma execução que imprime 200000 não demonstra ausência da corrida.
```

## Tema5V5 — Estado compartilhado protegido

```java
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
```

Saída/efeito esperado:

```text
200000
```

## Tema5V6 — Coordenador com vetor de threads

```java
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
```

Saída/efeito esperado:

```text
Nove linhas dos trechos em ordem variável entre motos.
A última linha é: Chegadas: 3
```
