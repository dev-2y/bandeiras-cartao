# Validador de Bandeiras de Cartão de Crédito

Este projeto em Java implementa uma funcionalidade para validar bandeiras de cartões de crédito com base nos prefixos e comprimentos de números de cartão. As bandeiras suportadas são baseadas nas informações disponíveis no site [4devs](https://www.4devs.com.br/gerador_de_numero_cartao_credito).

## Funcionalidades

- Identificação da bandeira de um cartão de crédito com base no número informado.
- Suporte para as seguintes bandeiras:
  - Visa
  - MasterCard
  - American Express
  - Diners Club
  - Discover
  - JCB
  - Elo
  - Hipercard
  - Aura
  - EnRoute
  - Voyager

## Como usar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/bandeiras-cartao.git
   ```

2. Compile o projeto:
   ```bash
   javac CardValidator.java
   ```

3. Execute o programa:
   ```bash
   java CardValidator
   ```

4. Insira o número do cartão no código (no método `main`) para testar a validação.

## Exemplo de Uso

No método `main`, você pode testar a validação de um número de cartão. Por exemplo:

```java
public static void main(String[] args) {
    String cardNumber = "6062826458903127"; // Exemplo de número Hipercard
    String brand = validateCardBrand(cardNumber);
    System.out.println("Bandeira: " + brand);
}
```

Saída esperada:
```
Bandeira: Hipercard
```

## Estrutura do Código

- **`CARD_BRANDS`**: Um mapa que contém as bandeiras e seus respectivos prefixos e comprimentos.
- **`validateCardBrand`**: Método principal que valida a bandeira do cartão.
- **`matchesPrefix`**: Verifica se o número do cartão corresponde a um dos prefixos da bandeira.
- **`matchesLength`**: Verifica se o comprimento do número do cartão é válido para a bandeira.

## Requisitos

- Java 8 ou superior.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Referências

- [4devs - Gerador de Número de Cartão de Crédito](https://www.4devs.com.br/gerador_de_numero_cartao_credito)