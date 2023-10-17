# buy-foreign-currency
Este projeto Java tem o objetivo de permitir que os usuários realizem ordens de compra de moedas estrangeiras de forma eficiente e conveniente, consumindo a API externa https://docs.awesomeapi.com.br/api-de-moedas para obter as taxas de câmbio. O sistema será composto por um back-end Java que lida com a lógica de negócios, integração com a API externa e armazenamento de dados.

## Funcionalidades
1- Seleção da moeda estrangeira desejada.
Cálculo do valor total com base na quantidade desejada e na taxa de câmbio atual.
Registro das ordens de compra no sistema.

## Pré-requisitos
Antes de iniciar, certifique-se de ter as seguintes dependências instaladas:

Java Development Kit (JDK) - Versão 17 ou superior.

## Configuração
Clone o repositório:

bash
Copy code
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
Configure as variáveis de ambiente:

Renomeie o arquivo application.properties.example para application.properties e preencha as variáveis de ambiente necessárias, como a URL da API externa.
