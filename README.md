# buy-foreign-currency
Este projeto Java tem o objetivo de permitir que os usuários realizem ordens de compra de moedas estrangeiras de forma eficiente e conveniente, consumindo a API externa https://docs.awesomeapi.com.br/api-de-moedas para obter as taxas de câmbio. O sistema será composto por um back-end Java que lida com a lógica de negócios, integração com a API externa e armazenamento de dados.

## Funcionalidades
- Consumir a Api externa https://economia.awesomeapi.com.br/USD-BRL
- 🔒 Cadastro, leitura, atualização e exclusão usuários.
- 🚀 Realização de order de compra de moeda.
- 📦 Cálculo do valor total com base na quantidade desejada e na taxa de câmbio
  atual.
- 🪙 Seleção da moeda estrangeira desejada (USD ou EUR).
- 💻 Autenticação com Jwt

## Pré-requisitos
Antes de iniciar, certifique-se de ter as seguintes dependências instaladas:

- Java Development Kit (JDK) - Versão 17 ou superior.
- Maven

## Configuração
Clone o repositório:

```bash
git clone https://github.com/Ar3secchim/buy-foreign-currency

cd buy-foreign-currency
```

## 1. Create (Criar)
O CRUD começa com a operação de criação, que envolve usuários novos
registros como um banco de dados.

Exemplo de Criação (Create) - Criando um usuário:

###  POST createUSer

``http://localhost:8080/user``

#### Body
```json
  {
  "nome": "nameUser",
  "cpf": "12345678965",
  "dataDeNascimento": 1997,
  "estadoCivil": "casado",
  "sexo": "F",
  "senha": "casado",
  "active": false
}
```

###  POST createOrder
Precisa de um usuário criado e autenticar o usuário com login e assim poderá
fazer uma order

``http://localhost:8081/order``

#### Request Headers

| Authorization      |                                                                                                                                                                                                                                         |
| ----------- |-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Bearer      | eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJyc0BnbWFpbC5jb20iLCJpZCI6MTAsIm5hbWUiOiJSZSBTZWNjaGltIiwiZXhwIjoxNjk2NjA0MzM1LCJpc3MiOiJjcnVkIn0.bFuiN9q461ayOz5OLUqDhWyGj2SF0rt-1OmUiWnjqx95mTscVKD5L2wN1bfpHEZldSaKfsBe7ukmDDpyaJHbSw |

#### Body
```json
  {
   "cpfUser":"12345678985",
   "typeCurrency": "USD",
   "valueForeignCurrency": 3500,
   "withdrawalAgencyNumber":"4448"
  }
```

#### Response
```json
  {
   "cpfUser":"12345678985",
   "typeCurrency": "USD",
   "valueForeignCurrency": 3500,
   "withdrawalAgencyNumber":"4448"
  }
```

## Tecnologias Utilizadas
- 💻 Linguagem de Programação: Java

## Maiores Desafios

- Fazer requisição para uma API externa
- Lidar com uma resposta de requisição de externa
- Aplicação de design SOLID 
