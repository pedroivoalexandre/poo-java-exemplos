# Tema 4 — Exceções

PEDRO IVO ALEXANDRE · POO em Java

[Apresentação](https://docs.google.com/presentation/d/1-z8EZv_FFNY4_fbtqD2WJ1_oWW9C__SmUCn6tAoyV98/edit) · [Compilador Java](https://www.jdoodle.com/online-java-compiler-ide)

Cada versão é independente: execute apenas um arquivo por vez. A classe pública aparece por último e contém main. Não combine classes Moto de versões diferentes no mesmo projeto.

Validação: revisão estática realizada; execução e integração online ainda pendentes nesta sessão por indisponibilidade do ambiente. Saídas abaixo são esperadas, não registros de execução.

## Tema4V1 — Conversão e tratamento

```java
public class Tema4V1 {
    public static void main(String[] args) {
        String[] entradas = {"60", "rapida", "40"};
        for (int i = 0; i < entradas.length; i++) {
            try {
                int v = Integer.parseInt(entradas[i]);
                System.out.println("Velocidade: " + v);
            } catch (NumberFormatException erro) {
                System.out.println("Formato invalido");
            }
        }
    }
}
```

Saída/efeito esperado:

```text
Velocidade: 60
Formato invalido
Velocidade: 40
```

## Tema4V2 — A moto preserva seu estado

```java
class Moto {
    private int velocidadeDesejada;
    Moto(int velocidade) {
        definirVelocidade(velocidade);
    }
    void definirVelocidade(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("Velocidade negativa");
        }
        velocidadeDesejada = velocidade;
    }
    int getVelocidadeDesejada() {
        return velocidadeDesejada;
    }
}
public class Tema4V2 {
    public static void main(String[] args) {
        Moto moto = new Moto(60);
        try {
            moto.definirVelocidade(-10);
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
        System.out.println(moto.getVelocidadeDesejada());
    }
}
```

Saída/efeito esperado:

```text
Velocidade negativa
60
```

## Tema4V3 — Formato, domínio e encerramento

```java
class Moto {
    private int velocidadeDesejada;
    Moto(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("Velocidade negativa");
        }
        velocidadeDesejada = velocidade;
    }
}
public class Tema4V3 {
    public static void main(String[] args) {
        String[] entradas = {"rapida", "-10", "60"};
        for (int i = 0; i < entradas.length; i++) {
            try {
                int v = Integer.parseInt(entradas[i]);
                new Moto(v);
                System.out.println("Cadastro aceito");
            } catch (NumberFormatException erro) {
                System.out.println("Formato invalido");
            } catch (IllegalArgumentException erro) {
                System.out.println("Valor invalido");
            } finally {
                System.out.println("Tentativa encerrada");
            }
        }
    }
}
```

Saída/efeito esperado:

```text
Formato invalido
Tentativa encerrada
Valor invalido
Tentativa encerrada
Cadastro aceito
Tentativa encerrada
```

## Tema4V4 — Exceção verificada do percurso

```java
class PercursoInvalidoException extends Exception {
    PercursoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
class Estrada {
    private int metros;
    Estrada(int metros) throws PercursoInvalidoException {
        if (metros <= 0) {
            throw new PercursoInvalidoException("Percurso sem tamanho");
        }
        this.metros = metros;
    }
    int getMetros() {
        return metros;
    }
}
public class Tema4V4 {
    public static void main(String[] args) {
        try {
            Estrada estrada = new Estrada(0);
            System.out.println(estrada.getMetros());
        } catch (PercursoInvalidoException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
```

Saída/efeito esperado:

```text
Percurso sem tamanho
```

## Tema4V5 — Fechamento automático de recurso

```java
import java.io.IOException;
import java.io.StringReader;

public class Tema4V5 {
    public static void main(String[] args) {
        try (StringReader leitor = new StringReader("90")) {
            System.out.println(leitor.read());
        } catch (IOException erro) {
            System.out.println("Falha na leitura");
        }
    }
}
```

Saída/efeito esperado:

```text
57
```
