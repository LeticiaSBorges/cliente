# Biblioteca

Este projeto consiste em criar um sistema de emprestimo de livros com a linguagem Java, utilizando JPA, DAO e o banco de dados H2.

O primeiro passo deste trabalho foi baixar os bibliotecas Spring Data JPA, Validation, H2 Database e Lombok, no link <https://start.spring.io/>.

Figura 1 - Start Spring.

![start_spring](images/start_spring_atualizado.png)

Spring Framework e é usada para simplificar o desenvolvimento de aplicativos Java baseados em persistência de dados. Ela combina o Spring Data e o Java Persistence API (JPA) para fornecer uma maneira mais fácil e produtiva de acessar e manipular bancos de dados relacionais em aplicativos Java.

 Validation permite que seja definido e aplicados as regras de validação a objetos no aplicativo Java especifico. Ele é usado para garantir que os dados inseridos ou manipulados em seu aplicativo estejam em conformidade com regras específicas antes de serem processados.

 O H2 Database é um banco de dados relacional escrito em Java, projetado principalmente para desenvolvimento e testes. Ele é usado para criar bancos de dados temporários em memória ou armazenados em arquivos para depuração, teste e prototipagem.

Lombok é uma biblioteca que ajuda a reduzir a verbosidade do código Java, evitando a escrita repetitiva de getters, setters, construtores, e outros métodos comuns em classes.

Os tabelas foram criadas com com base no relacionamento apresnetado na imagem abaixo.

Figura 2 - Tabelas Aluno, Publicação e Emprestimo.

![relacionamento_biblioteca](images/relacionamento_biblioteca.drawio.png)

Dessa forma foi criado o arquivo data.sql, no qual cria todas as tabelas que estão sendo utilizadas no projeto, aluno, publicacao e emprestimo.

Figura 3 - Scrip de criação das tabelas em SQL no arquivo data.sql.

![data_sql](images/data_sql.png)

Posteriormente foi criado a classes com mapeamento em JPA para aluno, publicação e emprestimo (localizado no diretório entity). Foi criado também a classe DAO para aluno, publiação e emprestimo. Foi necessário criar a classe DAO para alunos e publicação, pois para realizar o emprestimo, deve ser realizado o cadastro o aluno e a publicação.

O exemplo de teste de funcionamento da classe DAO de emprestimo foi realizado no arquivo EmprestimoExampleController.java, neste exemplo foi realizado cadastro de 3 alunos, 3 livros e três emprestimos. Veja as figuras a seguir.

Figura 4 - Script da classe EmprestimoExampleController.

![EmprestimoExampleController](images/EmprestimoExampleController.png)

Veja o retorno dos dados salvas pelo arquivo EmprestimoExampleController no Postman na request Salvar_Tabela_Emprestimos. Resaltando, a collection está disponivel na pasta "collection_postman", com as devidas configurações.

Figura 5 - Retorno dos dados salvos pela classe EmprestimoExampleController no Postman.

![postman_salvar](images/postman_salvar.png)

Para ver o retorno no banco H2, deve ser acessado o link <http://localhost:8080/console-h2>. A figura 6 apresenta os retornos nas tabelas.

Figura 6 - Retorno das tabelas no H2.

![h2_aluno](images/h2_aluno.png)

![h2_aluno](images/h2_publicacao.png)

![h2_aluno](images/h2_emprestimo.png)



