# API de Cadastro de Beneficiários

Esta é uma API RESTful desenvolvida para o gerenciamento de beneficiários e seus respectivos documentos. O projeto foi construído seguindo as melhores práticas de desenvolvimento Java com Spring Boot, visando atender aos requisitos de um desafio técnico para [Desenvolvedor Backend Java Junior - Empresa Kan](https://www.matheusleandro.com.br/desafios/desenvolvedor-backend-java) do [Matheus Leandro](https://www.matheusleandro.com.br/).

## 🚀 Tecnologias Utilizadas

* **Java 21** (ou versão utilizada no seu projeto)
* **Spring Boot 4.x**
* **Spring Data JPA**: Para persistência de dados.
* **H2 Database**: Banco de dados em memória para facilidade de teste e execução.
* **ThunderClient**: Testar requisições.
* **Maven**: Gerenciador de dependências.

## 📋 Funcionalidades

A API permite realizar as seguintes operações:

1. **Cadastrar um beneficiário** junto com seus documentos.
2. **Listar todos os beneficiários** cadastrados.
3. **Listar todos os documentos** de um beneficiário específico a partir de seu ID.
4. **Atualizar os dados** cadastrais de um beneficiário.
5. **Remover um beneficiário** (exclusão lógica ou física, conforme a regra de negócio).

## 🛠️ Como Executar o Projeto

### Pré-requisitos

* JDK 21 ou superior instalado.
* Maven instalado (opcional, pode usar o `./mvnw` incluso).

### Passos para execução

1. Clone o repositório:
```bash
git clone https://github.com/oDevFred/api-cadastro-beneficiarios.git

```


2. Acesse a pasta do projeto:
```bash
cd api-cadastro-beneficiarios

```


3. Compile e execute a aplicação:
```bash
./mvnw spring-boot:run

```


4. A API estará disponível em: `http://localhost:8080`

## 🧪 Testes

Para executar a suíte de testes unitários e de integração:

```bash
./mvnw test

```

---

### Estrutura de Endpoints Principais (Exemplos)

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `POST` | `/api/beneficiaries` | Cadastra um novo beneficiário |
| `GET` | `/api/beneficiaries` | Retorna todos os beneficiários |
| `PUT` | `/api/beneficiaries/{id}` | Atualiza dados de um beneficiário |
| `DELETE` | `/api/beneficiaries/{id}` | Remove um beneficiário |
| `GET` | `/api/beneficiaries/{id}/documentos` | Lista documentos de um beneficiário |

---

**Desenvolvido por [oDevFred](https://odevfred.codes/)**