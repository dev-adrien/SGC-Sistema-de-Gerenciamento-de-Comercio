# SGC - Sistema de Gestão Comercial (RM Versátil)

API RESTful desenvolvida para gestão comercial, englobando controle de catálogo de produtos, estoque físico, frente de caixa (PDV), emissão de recibos, trilha de auditoria e consolidação gerencial de faturamento.

---

## Tecnologias Utilizadas

* Java 21
* Spring Boot 4.1.1
* Spring Data JPA / Hibernate
* PostgreSQL
* SpringDoc OpenAPI 2.7.0 (Swagger UI)
* Apache Maven

---

## Módulos e Funcionalidades

* **Controle de Acesso e Configuração da Loja:** Autenticação de operadores, níveis de permissão (ADMIN, CAIXA, GERENTE) e parametrização dos dados cadastrais do estabelecimento comercial.
* **Catálogo e Clientes:** Categorização de produtos, controle de estoque mínimo e descontinuação de itens. Cadastro e manutenção de clientes Pessoa Física (PF) e Pessoa Jurídica (PJ).
* **Frente de Caixa (PDV):** Registro de vendas com cálculo automatizado de subtotais/totais, baixa automática de estoque físico e suporte a múltiplas formas de pagamento em transações atômicas.
* **Estorno de Vendas:** Cancelamento de vendas concluídas com motivo obrigatório e devolução automática dos itens ao estoque.
* **Comprovantes e Auditoria:** Emissão de recibos detalhados e registro automático de logs de auditoria para operações críticas do sistema.
* **Gestão e Relatórios:** Listagem direta de produtos abaixo do estoque mínimo e consolidado geral de faturamento agrupado por método de pagamento.

---

## Estrutura da Arquitetura

O projeto adota o padrão em camadas:

* `entities`: Mapeamento relacional de entidades com Jakarta Persistence.
* `repositories`: Interfaces de acesso a dados com Spring Data JPA.
* `services`: Regras de negócio, orquestração transacional e validações.
* `controllers`: Endpoints RESTful para comunicação HTTP.
* `dtos`: Objetos de transferência de dados (Data Transfer Objects) para isolamento de requisições e respostas.
* `config`: Configurações globais e documentação OpenAPI.

---

## Configuração e Execução

### Pré-requisitos
* Java Development Kit (JDK) 21 ou superior
* PostgreSQL em execução

### 1. Configuração do Banco de Dados
Defina as credenciais no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sgc_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
