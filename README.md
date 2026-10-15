# Exemplos de Programação Orientada a Objetos em Java

Professor: Pedro Ivo Alexandre

Exemplos progressivos utilizados nas aulas. Cada versão é independente e deve ser executada separadamente, pois algumas classes possuem o mesmo nome entre as versões.

## Tema 3

| Versão | Conteúdo | Código |
| --- | --- | --- |
| 1 | Herança, construtor e `super` | [Tema3V1.java](tema3/v1/Tema3V1.java) |
| 2 | Sobrescrita e polimorfismo | [Tema3V2.java](tema3/v2/Tema3V2.java) |
| 3 | Interface e implementação | [Tema3V3.java](tema3/v3/Tema3V3.java) |
| 4 | Vetor de objetos e polimorfismo | [Tema3V4.java](tema3/v4/Tema3V4.java) |
| 5 | Interface funcional e expressão lambda | [Tema3V5.java](tema3/v5/Tema3V5.java) |
| 6 | Integração de Moto e Estrada com classes aninhadas | [Tema3V6.java](tema3/v6/Tema3V6.java) |

Nas versões 1 a 5, as classes auxiliares aparecem antes da classe pública, que contém o método `main`. A versão 6 apresenta classes aninhadas.

## Executar

Instale um JDK 17 ou superior. Para executar a versão 1, entre na pasta correspondente e use:

```sh
cd tema3/v1
javac -encoding UTF-8 Tema3V1.java
java Tema3V1
```

Para outra versão, altere a pasta e o nome da classe conforme a tabela.

Acesse https://pedroivoalexandre.github.io/poo-java-exemplos/ e escolha o tema e a versão. O botão envia o código completo ao JDoodle; no editor, clique em Execute.

## Tema 2 - Complementação

Quatro versões independentes: [tipos e acesso protegido](tema2/v1/Tema2V1.java), [Object, equals e hashCode](tema2/v2/Tema2V2.java), [ArrayList](tema2/v3/Tema2V3.java) e [HashSet](tema2/v4/Tema2V4.java). O [complemento entre pacotes](tema2/pacotes) contém três arquivos para execução em um projeto Java.

## Tema 4 - Tratamento de exceções

Cinco versões: [conversão](tema4/v1/Tema4V1.java), [validação e ordem dos catches](tema4/v2/Tema4V2.java), [finally](tema4/v3/Tema4V3.java), [exceção própria](tema4/v4/Tema4V4.java) e [try-with-resources](tema4/v5/Tema4V5.java).
