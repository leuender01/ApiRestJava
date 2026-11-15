# Requisitos
## Requisitos Funcionais:
- Cadastrar um **livro**.
- Listar todos os livros **cadastrados**.
- Buscar um livro por **titulo**.
- Emprestar um livro com  **limite de emprestimos por usuário**.
- **Token** para **Autenticação** do usuário.
- **Multa** por atraso na devolução do livro.
- ***ENDPOINTS***:
    - ``` GET /livros ``` retorna todos os livros cadastrados
    - ``` GET  /cadastros ``` retorna todos os Usurios cadastrados.
    - ``` POST /cadastro ``` deve realizar o cadastro de um novo usuário.
    - ``` POST /login ``` deve realizar o login caso o **usuario esteja cadastrado** ou o **Token** ainda esteja **valido**.
    - ``` POST /livro/<nome-do-titulo> ``` deve realizar o emprestimo do livro informado, caso o cliente tenha cadastro, retornando uma chave de acesso nao conta do **Usuario**.
- O formato do retorno deve ser em **JSON**.
- **Testes** Unitarios com **JUNIT**.
- **POR ENQUANTO SEM BANCOS DE DADOS**.

## Requisitos Não Funcionais
- Busca de livros deve ser **rápida**.
- Buscar por autor, id, data.
- ***ENDPOINTS***:
    - ``` GET /healtcheck ``` retorna a saúde do sistema.

