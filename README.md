# Projeto Scheduler

Este projeto é um sistema para agendamento de transferências financeiras. Ele é desenvolvido usando Java, Spring Boot, JPA e H2.

## Estrutura do Projeto
**Arquitetura em Camadas**: A aplicação segue a arquitetura em camadas para garantir uma separação clara de responsabilidades.

- **Controller**: Responsável por receber as requisições HTTP e encaminhá-las para o serviço apropriado.
- **Service**: Contém a lógica de negócios da aplicação.
- **Repository**: Responsável pela comunicação com o banco de dados.
- **DTO (Data Transfer Objects)**: Utilizados para transferir dados entre as camadas da aplicação.

## Tecnologias Usadas

- **Java** (JDK 11)
- **Spring Boot**
- **JPA** (Hibernate)
- **H2** (Banco de dados em memória)
- **Maven** (Gerenciamento de dependências e build)

### Configuração do Banco de Dados

Utilizei o banco de dados **H2** para fins de desenvolvimento.

Adicione a seguinte configuração no arquivo `application.properties`:

```properties
spring.application.name=scheduler
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```
## GIT
Clone o repositório:
```properties
git clone https://github.com/isabelamedeiros/scheduler.git
cd scheduler
```
#### Comandos de Build
- **Compilar o projeto**: `mvn clean compile`
- **Construir o projeto**: `mvn clean install`
- **Execute a aplicação**: `mvn spring-boot:run`

## Documentação
A documentação da API está disponível no Swagger. Após iniciar o aplicativo, você pode acessá-la no seguinte endereço:
http://localhost:8080/swagger-ui/index.html

## Contato
Isabela Medeiros - mmedeirosisabela@gmail.com
