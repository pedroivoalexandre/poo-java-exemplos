# Atividade — Tema 5: Threads e concorrência

PEDRO IVO ALEXANDRE · POO em Java

Grupo: até três alunos. Preencher nome e matrícula de todos. Marcar uma alternativa por questão e apresentar a justificativa.

| Aluno | Matrícula |
|---|---|
| | |
| | |
| | |

Objetivas: 60% (12% por questão: alternativa 4%, justificativa 8%). Questão aberta: 40%. Justificativa avaliada pelo raciocínio, não pelo tamanho. Os exercícios consolidam a aula; a conclusão pode ocorrer fora do encontro.

## Questão 1 — 12%

A turma adaptou o percurso para que Moto implemente Runnable. O main cria duas Thread, cada uma recebendo uma Moto. Na primeira tentativa, chama a.run() e depois b.run(), e todas as mensagens de A aparecem antes das de B. O aluno interpreta a presença de dois objetos Thread como prova de execução concorrente.

Qual alteração e interpretação estão corretas?

a) Adicionar sleep entre as chamadas run, pois a pausa cria uma nova thread.

b) Manter run e aumentar o número de trechos até que a execução se torne concorrente.

c) Trocar Runnable por uma classe com todos os métodos static.

d) Chamar start nas duas threads e aceitar diferentes intercalações que preservem a ordem interna de cada tarefa.

e) Chamar start duas vezes na mesma Thread para representar as duas motos.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 2 — 12%

O coordenador deve anunciar o encerramento somente depois que duas motos terminarem. Ambas já foram criadas e iniciadas com start. Cada moto imprime três trechos e termina normalmente. O programador acrescentou Thread.sleep(500) no main antes de imprimir "Fim", supondo que meio segundo seja sempre suficiente.

Qual solução estabelece a condição desejada?

a) Aumentar a pausa para um segundo, tornando a espera independente da carga.

b) Executar join em cada thread iniciada antes de imprimir Fim.

c) Imprimir Fim no finally do main antes de aguardar as tarefas.

d) Diminuir a prioridade do main, o que estabelece uma ordem obrigatória.

e) Consultar apenas o tamanho do vetor, pois isso demonstra conclusão.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 3 — 12%

Duas motos compartilham a mesma instância de Placar. Cada tarefa chama registrar() cem mil vezes. O método faz apenas passagens++, sem sincronização. O main inicia as duas threads e executa join em ambas antes de consultar o total. Em uma execução o resultado foi 200000; na seguinte, foi menor.

Qual análise é adequada?

a) join impede a consulta antecipada, mas não torna o incremento atômico; synchronized na mesma instância de Placar pode proteger a operação.

b) O primeiro resultado demonstra que o programa está correto, portanto o segundo é defeito do compilador.

c) O erro ocorre porque join exige alternância obrigatória entre as motos.

d) Basta declarar uma variável local com o mesmo nome em cada tarefa para preservar o total compartilhado.

e) A sincronização de objetos Placar diferentes garante exclusão mútua sobre o contador original.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 4 — 12%

Para reduzir o tempo visual da demonstração, run chama Thread.sleep(50) a cada trecho. O método captura InterruptedException. O professor deseja que uma solicitação de interrupção durante a pausa encerre a tarefa e que essa informação não seja silenciosamente descartada.

Qual tratamento atende a essa intenção?

a) Capturar e ignorar a exceção, continuando normalmente todos os trechos.

b) Usar Thread.stop para terminar a tarefa em qualquer ponto.

c) Chamar start novamente dentro do catch para retomar a mesma Thread.

d) Capturar RuntimeException, pois InterruptedException pertence a essa hierarquia.

e) Restaurar a sinalização com Thread.currentThread().interrupt() e sair de run.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 5 — 12%

O main cria um vetor com três threads. No primeiro for, cria e inicia cada tarefa; no segundo, executa join em todas. Cada moto imprime trechos 1, 2 e 3 nessa ordem e registra uma chegada em um Placar compartilhado cujo método registrar é synchronized. Não ocorrem interrupções nem outras falhas.

Qual propriedade pode ser afirmada independentemente do escalonamento?

a) Todas as motos imprimem o trecho 1 antes que qualquer moto imprima o trecho 2.

b) A primeira thread criada sempre registra a primeira chegada.

c) Após todos os joins, o total é três; a ordem entre motos pode variar, mantendo-se a ordem dos trechos de cada uma.

d) A sincronização do registro obriga que cada percurso inteiro execute sozinho.

e) O segundo for inicia as tarefas que o primeiro ainda não executou.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 6 — 40%

Três motos devem percorrer três segmentos. Cada moto pode executar concorrentemente, mas deve imprimir seus segmentos na ordem 1, 2 e 3. Ao terminar, registra uma chegada num placar único. O coordenador só anuncia o total depois que todas encerram. Use vetor, classes auxiliares de nível superior e classe pública por último; não use listas, lambdas ou classes aninhadas.

a) Implemente Moto implements Runnable, com nome e referência ao Placar, percorrendo os três segmentos e registrando uma chegada.

b) Implemente Placar com contador privado e método synchronized para registrar. Explique por que a sincronização precisa proteger a mesma instância.

c) Escreva Tema5Atividade com main, Thread[] de tamanho três, um laço para criar/iniciar e outro para aguardar com join. Explique quais ordens são garantidas e quais podem variar.

Escrevam o código em espaços em branco identificados pelos itens a, b e c. Anexem folhas adicionais, se necessário.
