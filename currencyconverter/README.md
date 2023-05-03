# Converter Moeda 

Cotex conversion Currency

Aplicação responsável por criar conversão de moedas no Banco Central do Brasil.

---

A arquitetura aplicada escolhida foi a hexagonal, pois, comporta a fácil adaptabilidade entre
as camadas e seus componentes.

Para instalação é necessário realizar o clone do reposítório em sua máquina,
e importar para seu editor/IDE.

---

**ENTRADA**

http://localhost:8443/converte?data_cotacao=15/04/2022&moeda_origem=BRA&moeda_final=EUA&valor=89

**SAÍDA**

-> 4.55

Status: 200 OK

---

*OBSERVAÇÕES*

Sobre o sistemas de filas, pra mim não conseguir identificar a descrição
da premissa da ordem de prioridade. Mas uma questão limitadora é que, 
para aplicar uma solução em filas, pensei em algumas tecnologias como o uso de
filas do SQS na aws, ou algum serviço KAFKA, que trabalhasse a questão 
de prioridade com base em alguma informação enviada para o Tópico. Por essas razões não
consegui identificar com base no que foi solicitado uma forma de desenvolvimento em código
ou alguma estrutura de dados já existente.

Com relação ao cache, pude aplicar a partir da biblioteca que o spring oferece
a adição de cache, adicionando uma configuração de time de expiração dos dados recebidos
da request.

---


