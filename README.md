# Projeto Java Spring Boot

## Estrutura do Projeto

`````bash
com.thiago.transaction_api
├── controller
├── domain
│   ├── dto
│   ├── entities
│   ├── exceptions
│   └── enums
├── repositories
└── service
`````
## Dependências

* Spring Web 
* Lombok 
* JPA 
* PostgreSQL 
* SpringFox Swagger UI

## Pré-requisitos

* Java 11+ 
* Docker 
* Maven


## Configuração do Banco de Dados

<p> O banco de dados PostgreSQL está 
configurado para rodar em um container Docker. Para iniciar o container, 
utilize o comando: </p>

`````bash
docker run --name transactions -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=educacaovirtual -p 5431:5432 -d postgres
`````
## Configuração do Spring Boot

As configurações do banco de dados no Spring Boot estão no arquivo application.properties:

`````bash
spring.datasource.url=jdbc:postgresql://localhost:5431/educacaovirtual
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
`````

## Exemplos de Endpoints

<img alt="EndPoints" src= img/Endpoint.png>

## Contribuindo

Para contribuir com o projeto, faça um fork do repositório e crie uma nova branch para suas alterações. Envie um pull request após concluir suas alterações.
