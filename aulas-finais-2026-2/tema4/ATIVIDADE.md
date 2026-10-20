# Atividade — Tema 4: Exceções

PEDRO IVO ALEXANDRE · POO em Java

Grupo: até três alunos. Preencher nome e matrícula de todos. Marcar uma alternativa por questão e apresentar a justificativa.

| Aluno | Matrícula |
|---|---|
| | |
| | |
| | |

Objetivas: 60% (12% por questão: alternativa 4%, justificativa 8%). Questão aberta: 40%. Justificativa avaliada pelo raciocínio, não pelo tamanho. Os exercícios consolidam a aula; a conclusão pode ocorrer fora do encontro.

## Questão 1 — 12%

A equipe que mantém o simulador recebe velocidades em um arquivo de texto. Foram lidas, nessa ordem, as entradas "60", "rapida" e "40". Para cada entrada, o programa executa Integer.parseInt dentro de um try localizado no corpo do for; o catch de NumberFormatException informa a rejeição. Nenhuma outra exceção é lançada e o laço não contém break ou return.

Qual comportamento corresponde a essa estrutura?

a) Somente 60 é processado, pois qualquer catch encerra o for.

b) As três entradas são aceitas; a conversão de texto inválido produz zero.

c) 60 e 40 são processados, e somente a entrada intermediária é rejeitada.

d) A entrada rapida é repetida automaticamente até se tornar válida.

e) Nenhuma entrada é processada, pois a presença do catch impede a execução do try.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 2 — 12%

Uma moto já cadastrada está com velocidade desejada igual a 60. Um método de alteração recebe -10, primeiro grava o argumento no atributo e depois verifica se ele é negativo, lançando IllegalArgumentException. O main captura a exceção e informa que a alteração foi rejeitada. Uma consulta posterior revela -10 no objeto.

Que mudança preserva a consistência do objeto e a responsabilidade da classe Moto?

a) Validar o argumento antes da atribuição e lançar a exceção sem alterar o estado anterior.

b) Manter a atribuição e retirar o catch para que o atributo volte automaticamente ao valor anterior.

c) Transferir toda a validação para a tela e permitir que Moto aceite qualquer argumento.

d) Trocar IllegalArgumentException por Exception, pois uma exceção verificada desfaz atribuições.

e) Colocar a atribuição em finally para garantir que uma tentativa sempre modifique o objeto.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 3 — 12%

O cadastro distingue problemas de representação e de domínio. Integer.parseInt pode lançar NumberFormatException; o construtor Moto pode lançar IllegalArgumentException para velocidade negativa. O programador escreveu catch (IllegalArgumentException e) seguido de catch (NumberFormatException e), desejando oferecer mensagens diferentes. NumberFormatException é subclasse de IllegalArgumentException.

Qual análise explica o resultado e a correção?

a) Os dois catches executam para a mesma exceção e a ordem define a mensagem final.

b) A ordem é válida apenas quando a entrada for um número negativo.

c) O segundo catch tem prioridade por ter um nome de tipo mais longo.

d) A execução escolhe aleatoriamente um dos catches compatíveis.

e) O catch específico fica inalcançável; ele deve anteceder o catch do supertipo.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 4 — 12%

A operação preparar() declara throws PercursoInvalidoException. Dentro dela, o try lança essa exceção antes da mensagem "Pronto"; o finally imprime "Encerrado". Não há catch nesse método, nem return no finally. O main chama preparar() dentro de try e captura PercursoInvalidoException, imprimindo "Rejeitado". A JVM permanece em execução normal.

Que sequência de mensagens é produzida?

a) Pronto, Encerrado e Rejeitado.

b) Encerrado e Rejeitado.

c) Rejeitado e Encerrado.

d) Somente Rejeitado.

e) Somente Encerrado, pois finally elimina a exceção.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 5 — 12%

O gerador automático passou a rejeitar trechos de comprimento zero. A equipe criou PercursoInvalidoException extends Exception e a lança no método gerar. Um colega acrescentou apenas throws PercursoInvalidoException à assinatura de gerar e afirmou que isso já exibe uma mensagem ao aluno e permite continuar a geração. Outro colega propôs capturar Exception e ignorá-la.

Qual decisão atende ao contrato da operação?

a) Retornar um percurso vazio no finally, mesmo após detectar um erro.

b) Retirar a exceção e imprimir sucesso, deixando que a aula detecte o percurso vazio.

c) Transformar a exceção em Error para que qualquer chamador seja obrigado a capturá-la.

d) Declarar ou tratar a exceção nos pontos necessários e capturá-la onde seja possível decidir uma recuperação, sem ocultar a falha.

e) Manter somente throws, pois essa palavra executa o tratamento e reinicia o método.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 6 — 40%

Uma equipe usa Moto/Estrada para receber três configurações: velocidade desejada em texto e comprimento do percurso em metros. O sistema deve distinguir texto inválido, velocidade negativa e percurso sem tamanho. A configuração anterior de uma moto válida deve ser preservada se uma alteração falhar. A interface decide a mensagem ao usuário; as classes do domínio mantêm as regras.

a) Implemente Moto com atributo privado, construtor, getter e método de alteração que rejeite velocidade negativa antes de mudar o estado.

b) Implemente PercursoInvalidoException extends Exception e Estrada com construtor que a lance quando o comprimento não for positivo.

c) Escreva Tema4Atividade com main que demonstre uma entrada válida, uma textual inválida e uma violação de domínio; use captura específica e finally, e explique o que não é desfeito automaticamente.

Escrevam o código em espaços em branco identificados pelos itens a, b e c. Anexem folhas adicionais, se necessário.
