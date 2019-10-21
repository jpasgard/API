## Disponível para testes
```
GET https://handsy-api.herokuapp.com/device/1
GET https://handsy-api.herokuapp.com/device/2
GET https://handsy-api.herokuapp.com/device/3
GET https://handsy-api.herokuapp.com/device/4
```

## Handsy
Handsy é uma Startup que iniciou no curso de Ciência da Computação do Centro Universitário de João Pessoa(UNIPÊ), composta por estudantes que perceberam a necessidade da sociedade para conectar-se com os objetos que os cercam. A Handsy propõe uma maneira fácil e rápida para estabelecer essa conectividade, primeiro disponibilizando um dispositivo (Handsy) que vem acompanhado de um QR Code na embalagem onde os usuários poderão parear com o aplicativo de gerenciamento do dispositivo, no qual será necessário realizar um pré cadastro para ter acesso. Efetuando o login, os usuários poderão gerenciar seus objetos de forma remota.


## Handsy API
Handsy-API é um dispositivo com o intuito de facilitar a vida das pessoas. Como forma de interação o dispositivo é controlado remotamente através do aplicação mobile [Handsy](https://github.com/nearcp/Handsy-APP). Handsy foi criado utilizando um NodeMCU, e um relé para acionar dispositivos.

Handsy funciona através do estilo de arquitetura _Representational State Transfer (REST)_ através de requisições a servidores WEB para atualizar os estados dos dispositivos relé (portas) gerenciados pelo componente NodeMCU.

Requisições são realizadas através do verbo GET do protocolo HTTP como o exemplo abaixo:
```
http://<dominio>:<porta>/<caminho/<idnode>
```
A resposta da requisição é em formado JSON como o exemplo a baixo:
```json
{
   "0": true,
   "1": false,
   "2": false,
   "3": true
}
```

## Modelo de Negócio
![canvas-1](https://user-images.githubusercontent.com/14323599/67221893-99441a80-f402-11e9-92b6-5475f8a9e7c5.jpg)

O **_Business_** Model Canvas ou “Quadro de modelo de negócios” é uma ferramenta de gerenciamento estratégico, que permite desenvolver e esboçar modelos de negócio novos ou existentes. É um mapa visual pré-formatado contendo nove blocos do modelo de negócios. O Business Model Canvas foi inicialmente proposto por Alexander Osterwalder baseado no seu trabalho anterior sobre Business Model Ontology.

As descrições formais do negócio se tornam os blocos para construir suas atividades. Existem várias conceitualizações diferentes de negócio; o trabalho e a tese de Osterwalder (2010, 2004) propõem um modelo único de referência baseado nas semelhanças de um vasto número de conceitualizações de modelo de negócios. Com seu padrão de design de modelo de negócios, uma empresa pode facilmente descrever seu modelo de negócios.

_Referência:_ [Wikipédia](https://pt.wikipedia.org/wiki/Business_Model_Canvas)


## Integrantes do Grupo
[Nitai Charan Álvares Pereira](https://www.linkedin.com/in/nitaicharan/)
<br/>Curso: Ciência da Computação
<br/>Matrícula: 1510010557
<br/>Período: 7°

[Alvaro Philipe Andrade dos Santos](https://www.linkedin.com/in/alvaro-andrade-48596b117/)
<br/>Curso: Ciência da Computação
<br/>Matrícula: 1610015475
<br/>Período: 7°

[Rafael Matheus Pereira de Castro](https://www.linkedin.com/in/rafael-m-castro/)
<br/>Curso: Ciência da Computação
<br/>Matrícula: 1610014657
<br/>Período: 7°

[Paulo Guilherme Venancio da Silva](https://www.linkedin.com/in/gui9394/)
<br/>Curso: Ciência da Computação
<br/>Matrícula: 1520012543
<br/>Período: 7°

[Eduardo Laurentino Diniz Pereira](https://www.linkedin.com/in/eduardo-diniz-dev/)
<br/>Curso: Ciência da Computação
<br/>Matrícula: 1610014306
<br/>Período: 6°- 7°

[Cristian de Assis Alves](https://www.linkedin.com/in/cristian-alves-2531a110b/)
<br/>Curso: Ciência da Computação
<br/>Matrícula: 1510009696
<br/>Período: 6°- 7°
