# Farmácia API
![Java](https://img.shields.io/badge/Java-17-blue) ![SpringBoot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen) ![Maven](https://img.shields.io/badge/Maven-Build-orange) ![MySQL](https://img.shields.io/badge/MySQL-8.0-blue) ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-yellowgreen)

[Sobre o Projeto](#sobre-o-projeto) | [Tecnologias Utilizadas](#tecnologias-utilizadas) | [Funcionalidades](#funcionalidades) | [Diagrama de Classes](#diagrama-de-classes) | [Estrutura do Projeto](#estrutura-do-projeto) | [Práticas Adotadas](#práticas-adotadas) | [Endpoints da API](#endpoints-da-api) | [Regras de Negócio Implementadas](#regras-de-negócio-implementadas) | [Pré-requisitos](#pré-requisitos) | [Como Executar o Projeto](#como-executar-o-projeto) | [Como Executar na IDE](#como-executar-na-ide)



## Sobre o Projeto
Esta é uma API REST desenvolvida em **Java** com **Spring Boot** para gerenciar laboratórios e medicamentos de uma farmacia, seguindo os princípios da Programação Orientada a Objetos (POO).

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL**
- **Spring Tool Suite**


## Funcionalidades
- A aplicação permite a criação, visualização, atualização e remoção **(CRUD)** de laboratórios e medicamentos.
- Associa medicamentos a um laboratório específico.
- A aplicação permite que laboratórios cadastrem seus medicamentos, armazenando dados como nome, lote, data de fabricação, data de validade, preço de custo, preço de venda e quantidade em estoque.
- Tratamento de respostas de erro com  exceções personalizadas.
## Diagrama de Classes

```plaintext
+----------------+                 +----------------+  
|  Laboratorio   |                 |  Medicamento   |  
+----------------+                 +----------------+  
| - cnpj         |                 | - id           |  
| - nome         |                 | - nome         |  
| - endereco     |  1          N   | - lote         |  
| - email        | --------------- | - fabricacao   |  
| - telefone     |                 | - validade     |  
+----------------+                 | - precoCusto   |  
| + get/set()    |                 | - precoVenda   |  
+----------------+                 | - quantidade   |  
                                   +----------------+  
                                   | + get/set()    |  
                                   +----------------+  
```

## Estrutura do Projeto

```
/src/main/java/com/raniele/farmacia
├── controladores/            # Controladores REST
├── entidades/                # Entidades
├── repositorios/             # Interfaces de acesso ao banco (Spring Data JPA)
├── servicos/                 # Lógica de negócio
├── excecoes/                 # Tratamento de exceções personalizadas
└── FarmaciaApplication.java  # Classe principal do Spring Boot
```

## Práticas Adotadas
- Arquitetura MVC
- Uso de Spring Data JPA para persistência
- Tratamento de exceções personalizadas.
- Uso de PatchMapping para atualizações parciais
- Injeção de Dependências
- Separação clara das responsabilidades de cada classe, seguindo o princípio SRP (Single Responsibility Principle).
- Validações de regras de negócio para evitar dados inconsistentes.

## Endpoints da API

### **Laboratórios** (`/laboratorios`)

- **GET `/laboratorios`** - Retorna todos os laboratórios
- **GET `/laboratorios/{id}`** - Retorna um laboratório por CNPJ
- **POST `/laboratorios`** - Cadastra um novo laboratório
- **PATCH `/laboratorios/{id}`** - Atualiza parcialmente um laboratório
- **DELETE `/laboratorios/{id}`** - Deleta um laboratório

### **Medicamentos** (`/medicamentos`)

- **GET `/medicamentos`** - Retorna todos os medicamentos
- **GET `/medicamentos/{id}`** - Retorna um medicamento por ID
- **POST `/medicamentos`** - Cadastra um novo medicamento
- **PATCH `/medicamentos/{id}`** - Atualiza parcialmente um medicamento
- **DELETE `/medicamentos/{id}`** - Deleta um medicamento

## Regras de Negócio Implementadas

1. **Validações ao cadastrar um medicamento:**
   - O preço de custo **não pode ser maior** que o preço de venda.
   - O preço de venda **não pode ser zero ou negativo**.
   - A quantidade **deve ser maior que zero**.
   - A data de fabricação **não pode ser maior** que a data de validade.

2. **Exceções personalizadas:**
   - `RecursoNaoEncontradoExcecao` - Quando um recurso não é encontrado.
   - `PrecoInvalidoExcecao` - Quando o preço de um medicamento não atende às regras.
   - `QuantidadeNegativaExcecao` - Quando a quantidade de medicamentos é inválida.
   - `DatasInvalidasExcecao` - Quando as datas de fabricação e validade estão incorretas.

## Pré-requisitos
- Java 17
- Maven
- Banco de Dados MySQL
- Postman ou Insomnia (opcional)

## Como Executar o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/RanieleFeitosa/Farmacia-API.git
   cd farmacia
   ```
2. Configure o banco de dados no arquivo `application.properties` 
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/farmacia
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.username=root
   spring.datasource.password=senha_aqui
   ```
3. Compile e execute a aplicação com Maven:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. Acesse a API em: `http://localhost:8080`


## Como Executar na IDE
1. Abra a IDE (IntelliJ IDEA, Eclipse, VS Code).
2. Importe o projeto como um projeto **Maven**.
3. Aguarde a IDE baixar as dependências.
4. Execute a classe principal `FarmaciaApplication.java`.
5. Acesse os endpoints no navegador ou via Postman/Insomnia.
---
[🔼 Voltar ao topo](#farmácia-api)
