# QUARKUS-APP-REACTIVE

Exemplo de projeto feito em Quarkus para demonstrar a interação com o banco de dados PostgreSQL por meio de programação reativa.

## Dependências
- Quarkus 2.7.1
- JDK 11
- PostgreSQL 12.2
- Docker 4.5.1

## Passos para execução do projeto

Se você já executou o projeto [quarkus-app-jdbc](https://github.com/alissonmelonascimento/quarkus-app-jdbc), pule para o **passo 3**.
**Não se esqueça de subir o docker daquele projeto**.

> **Passo 1: Execute o docker**
```bash
  docker compose up
```

> **Passo 2: Habilite o flyway.** 
Abra o arquivo **application.properties** e altere a seguinte propriedade:
```bash
  myapp.flyway.migrate = true
```

> **Passo 3: Execute o projeto.** 
```bash
  mvnw quarkus:dev
```

> **Passo 4: Faça uma chamada à API**
```bash
  http://localhost:8080/fruits
```