# Atividade — Tema 6: Banco de dados com JDBC

PEDRO IVO ALEXANDRE · POO em Java

Grupo: até três alunos. Preencher nome e matrícula de todos. Marcar uma alternativa por questão e apresentar a justificativa.

| Aluno | Matrícula |
|---|---|
| | |
| | |
| | |

Objetivas: 60% (12% por questão: alternativa 4%, justificativa 8%). Questão aberta: 40%. Justificativa avaliada pelo raciocínio, não pelo tamanho. Os exercícios consolidam a aula; a conclusão pode ocorrer fora do encontro.

## Questão 1 — 12%

O cadastro de motos recebe nomes digitados pelos alunos, inclusive nomes com apóstrofo. Uma implementação monta INSERT concatenando esse texto ao SQL. A equipe deseja corrigir erros de delimitação e evitar que a entrada seja interpretada como parte da instrução. A conexão JDBC já está aberta.

Qual implementação é apropriada?

a) Remover todas as letras e sinais do nome antes de salvar, mantendo apenas números.

b) Montar INSERT com marcadores ?, usar PreparedStatement e associar os valores com os métodos set correspondentes.

c) Trocar executeUpdate por executeQuery e manter a concatenação.

d) Inserir o texto diretamente no nome da tabela para evitar aspas.

e) Usar ResultSet para substituir o texto concatenado antes de executar o INSERT.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 2 — 12%

Após salvar duas motos, a aplicação executa SELECT id, nome, velocidade FROM moto ORDER BY id por executeQuery. O programador tenta ler getString("nome") imediatamente sobre o ResultSet retornado, antes de chamar next. A consulta poderia retornar zero, uma ou várias linhas.

Qual procedimento percorre corretamente o resultado?

a) Ler os valores antes de next e chamar executeUpdate para avançar.

b) Usar if (resultado != null) e assumir que isso comprova a existência de uma linha.

c) Chamar close antes da leitura para estabilizar o resultado.

d) Repetir while (resultado.next()) e ler as colunas dentro do corpo do laço.

e) Chamar next uma única vez depois de imprimir todas as colunas de todas as linhas.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 3 — 12%

Uma moto de id 7 tem velocidade 60 já confirmada no banco. Na mesma conexão, o programa desativa autoCommit, atualiza essa velocidade para 80 e tenta inserir outra moto também com id 7. A segunda instrução falha por chave primária. O catch chama rollback com sucesso; nenhum DDL ou commit ocorre entre a atualização e a falha.

Qual estado permanece após o tratamento?

a) A moto original continua com 60 e o registro duplicado não é inserido.

b) A moto original fica com 80 porque executeUpdate confirma qualquer transação.

c) As duas motos ficam salvas com o mesmo id.

d) A tabela inteira é removida por rollback.

e) A moto original é excluída automaticamente para abrir espaço à duplicada.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 4 — 12%

No laboratório online, duas conexões pertencentes à mesma aplicação usam jdbc:h2:mem:turma. A primeira cria uma tabela, insere uma moto e confirma a transação; a segunda consulta enquanto a primeira permanece aberta. Ao final, ambas são fechadas. Não foi configurado DB_CLOSE_DELAY. O aluno executa novamente o programa em um novo processo Java.

Qual interpretação corresponde ao uso do H2 em memória?

a) O banco fica armazenado permanentemente na conta do compilador por ter um nome.

b) A segunda conexão jamais acessa a tabela, mesmo no mesmo processo e com o banco ainda aberto.

c) A confirmação transforma automaticamente o banco em memória em arquivo persistente.

d) Cada comando SQL abre um banco diferente, mesmo na mesma conexão.

e) As conexões podem compartilhar o banco na mesma JVM; a execução em novo processo não recupera automaticamente os dados anteriores.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 5 — 12%

O projeto passou a separar Moto, MotoDAO e main. O main abre uma Connection e a fornece ao DAO; o DAO cria comandos e ResultSet para salvar e buscar motos. Uma rotina usa dois métodos do DAO na mesma transação, e o main decide entre commit e rollback. Todos os recursos precisam ser encerrados por seus responsáveis.

Qual distribuição mantém essa organização?

a) Moto abre uma nova conexão em cada getter, pois o objeto deve conhecer todos os detalhes do banco.

b) Cada método do DAO fecha a conexão recebida, mesmo que o main ainda precise dela.

c) O DAO fecha comandos e resultados que criou; o main mantém e fecha sua Connection e controla a transação.

d) O ResultSet fica aberto indefinidamente para evitar nova consulta.

e) O main ignora SQLException para permitir que o DAO confirme operações parcialmente executadas.

Alternativa: ______

Justificativa:

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

________________________________________________________________________________

## Questão 6 — 40%

O sistema deve cadastrar motos num banco H2 em memória usando JDBC. A tabela moto possui id como chave primária, nome e velocidade não negativa. Use a biblioteca com.h2database:h2:2.3.232. O main é dono da conexão e o DAO recebe essa conexão. A criação da tabela e a carga inicial ocorrem antes de iniciar a transação usada no item c.

a) Defina a tabela e implemente MotoDAO.salvar com PreparedStatement, três parâmetros e fechamento do comando. Mantenha a regra de velocidade no modelo ou em validação explicitada.

b) Implemente uma consulta ordenada com executeQuery, while/next, leitura por coluna e fechamento de ResultSet e comando. Demonstre no main a consulta de dois registros.

c) Desative autoCommit, atualize uma moto e force uma inserção de chave duplicada. Confirme apenas se tudo der certo; diante de SQLException, execute rollback. Consulte o estado final e explique por que este banco não persiste entre novas execuções.

Escrevam o código em espaços em branco identificados pelos itens a, b e c. Anexem folhas adicionais, se necessário.
