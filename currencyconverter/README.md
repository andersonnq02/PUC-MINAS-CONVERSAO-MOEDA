# Converter Moeda 

conversion Currency

Aplicação responsável por criar conversão de moedas e utiliza API Exchangeratesapi.

---

A arquitetura aplicada escolhida foi a hexagonal, pois, comporta a fácil adaptabilidade entre
as camadas e seus componentes.

Para instalação é necessário realizar o clone do reposítório em sua máquina,
e importar para seu editor/IDE.

---
Exemplo de ENDPOINT

**ENTRADA**

http://localhost:8080/currency-converter/moedas

**SAÍDA**

    [
        {
            "codigo": "USD",
            "nome": "Dólar Americano",
            "simbolo": "$"
        }
    ]

Status: 200 OK



