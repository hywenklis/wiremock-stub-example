# Demo FIPE – Spring Boot, Feign & WireMock

Exemplo de integração de um serviço Spring Boot que consulta valores de veículos usando uma API FIPE simulada via WireMock.

## Tecnologias

- Java 21
- Spring Boot 3.4.x
- Spring Cloud OpenFeign
- Spring Cloud Contract WireMock
- AssertJ

## Como executar

```bash
# Execute os testes (WireMock é iniciado automaticamente nos testes)
./mvnw test

# Para rodar a aplicação localmente
./mvnw spring-boot:run
````

## Exemplo de requisição

```
GET /fipe/value?brand=CHEVROLET&model=ONIX&year=2020
```

## Estrutura dos stubs

```
src/test/resources/mappings/    # arquivos JSON de configuração dos endpoints mockados
src/test/resources/__files/     # arquivos com o conteúdo das respostas mockadas
```
