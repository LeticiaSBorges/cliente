# Biblioteca

Este projeto consiste em criar um sistema de emprestimo de livros com a linguagem Java, utilizando JPA, DAO e o banco de dados H2.

O primeiro passo deste trabalho foi baixar os bibliotecas Spring Data JPA, Validation, H2 Database e Lombok, no link <https://start.spring.io/>.

Figura 1 - Start Spring.

![start_spring](imagens/start_spring_atualizado.png)

Spring Framework e é usada para simplificar o desenvolvimento de aplicativos Java baseados em persistência de dados. Ela combina o Spring Data e o Java Persistence API (JPA) para fornecer uma maneira mais fácil e produtiva de acessar e manipular bancos de dados relacionais em aplicativos Java.

 Validation permite que seja definido e aplicados as regras de validação a objetos no aplicativo Java especifico. Ele é usado para garantir que os dados inseridos ou manipulados em seu aplicativo estejam em conformidade com regras específicas antes de serem processados.

 O H2 Database é um banco de dados relacional escrito em Java, projetado principalmente para desenvolvimento e testes. Ele é usado para criar bancos de dados temporários em memória ou armazenados em arquivos para depuração, teste e prototipagem.

Lombok é uma biblioteca que ajuda a reduzir a verbosidade do código Java, evitando a escrita repetitiva de getters, setters, construtores, e outros métodos comuns em classes.

Os tabelas foram criadas com com base no relacionamento apresnetado na imagem abaixo.

Figura 2 - Tabelas Aluno, Publicação e Emprestimo.

![relacionamento_biblioteca](imagens/relacionamento_biblioteca.drawio.png)

Dessa forma foi criado o arquivo data.sql, no qual cria todas as tabelas que estão sendo utilizadas no projeto, aluno, publicacao e emprestimo.

Figura 3 - Script de criação das tabelas em SQL no arquivo data.sql.

![data_sql](imagens/data_sql.png)

Posteriormente foi criado a classes com mapeamento em JPA para aluno, publicação e emprestimo (localizado no diretório entity). Foi criado também a classe DAO para aluno, publiação e emprestimo. Foi necessário criar a classe DAO para alunos e publicação, pois para realizar o emprestimo, deve ser realizado o cadastro o aluno e a publicação.

O exemplo de teste de funcionamento da classe DAO de emprestimo foi realizado no arquivo EmprestimoExampleController.java, neste exemplo foi realizado cadastro de 3 alunos, 3 livros e três emprestimos. Veja as figuras a seguir.

Figura 4 - Script da classe EmprestimoExampleController.

![EmprestimoExampleController](imagens/EmprestimoExampleController.png)


Veja o retorno dos dados salvas pelo arquivo EmprestimoExampleController no Postman na request Salvar_Tabela_Emprestimos. Resaltando, a collection está disponivel na pasta "collection_postman", com as devidas configurações.

Figura 5 - Retorno dos dados salvos pela classe EmprestimoExampleController no Postman.

![postman_salvar](imagens/postman_salvar.png)

Para ver o retorno no banco H2, deve ser acessado o link <http://localhost:8080/console-h2> (pode ser visualizado no arquvio "link_acesso.txt"). A figura 6 apresenta os retornos nas tabelas.

Figura 6 - Retorno das tabelas no H2.

![h2_aluno](imagens/h2_aluno.png)

![h2_publicacao](imagens/h2_publicacao.png)

![h2_emprestimo](imagens/h2_emprestimo.png)

Para lista  tabela no postman deve ser utilizada a request Consultar_Tabela_Emprestimos. Veja a figura a seguir.

Figura 7 - Retorno de todos os dados salvos na tabela Emprestimo.

![postman_listar_tabela](imagens/postman_listar_tabela.png)

A atualização de um emprestimo, deve utilizado o request Atualizar_Emprestimo_por_ID, e selecionar o id a ser atualizado, nesse casos o id 2 (http://localhost:8080/cliente/emprestimo/exemplo/atualizar/2),
no qual foi alterado a data de devolução com as seguintes informações:

{

    "dtemprestimo": "15/10/2023",
    
    "dtdevolucao": "16/10/2023"
    
}

A figura 8 apresenta detalhamente do que foi realizado.

Figura 8 - Atualização do emprestimo com id 2.

![postman_atualizar](imagens/postman_atualizar.png)

Para deletar um emprestimo deve ser utilizado a request Deletar_Emprestimo, nesse exemplo está deletando o id 3 (http://localhost:8080/cliente/emprestimo/exemplo/deletar/3).

Figura 9 - Deletar o emprestimo de id 3.

![postman_deletar](imagens/postman_deletar.png)

E por fim, para consultar um emprestimo por id deve ser utilizado a request Consultar_Emprestimo_por_ID, nesse exemplo está retornando o id 1 (http://localhost:8080/cliente/emprestimo/exemplo/consultar/1).

Figura 10 - Consulta do emprestimo de id 1.

![postman_consultar](imagens/postman_consultar_id.png)

Seguindo todos os passos e os arquivos fornecidos o resulta pode ser observado na figura a seguir, onde pode ser observado a alteração da data de entrega no emprestimo de id igual a 2 (atualização realizada conforme o figura 8) e a apresentação apenas dos ID's 1 e 2 (o terceiro foi deletado como mostrado no figura 9) .

![resultado](imagens/resultado.png)

## Passos para utilização deste projeto

**1º passo:** Rode o arquivo ClienteApplication.java

![ClienteApplication](imagens/ClienteApplication.png)

**2º passo:** Importe a collection "Java_Biblioteca_Exemplo_Aplicado_Java.postman_collection.json" no postaman, localizado na pasta "collection-postman".

![postman_1](imagens/postman_1.png)

![postman_2](imagens/postman_2.png)

**3º passo:** Selecione a request Salvar_Tabela_Emprestimos e clique em 'Send'.

![postman_3](imagens/postman_3.png)

**4º passo:** Abra o link  <http://localhost:8080/console-h2> para visualizar no banco H2.

![h2_aluno](imagens/h2_aluno.png)

![h2_publicacao](imagens/h2_publicacao.png)

![h2_emprestimo](imagens/h2_emprestimo.png)

**5º passo:** Para atulizar a tabela emprestimo deve ser utilizado a request "Atualizar_Emprestimo_por_ID" da collection "Java_Biblioteca_Exemplo_Aplicado_Java.postman_collection.json" importada no passo 2. Esta request já possui um exemplo de alteração do empprestimo do id 2.

![postman_atualizar](imagens/postman_atualizar.png)

**6º passo:** Para deletar um emprestimo, utilize a request "Deletar_Emprestimo", nela já possui um exemplo do emprestimo id 3 deletado.

![postman_deletar](imagens/postman_deletar.png)

**7º passo:** Para lista todos os dados da tabela emprestimo deve ser utilizado a request "Consultar_Tabela_Emprestimos" e para lista apenas um emprestimo por id dever ser utilizado "Consultar_Emprestimo_por_ID" (nesta request está utilizando o id 1).

![postman_listar_tabela](imagens/postman_listar_tabela.png)

![postman_consultar](imagens/postman_consultar_id.png)

## Explicação de cada arquivo
