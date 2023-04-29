

<h2><a href= "https://www.mackenzie.br">Universidade Presbiteriana Mackenzie</a></h2>
<h3><a href= "https://www.mackenzie.br/graduacao/sao-paulo-higienopolis/sistemas-de-informacao">Sistemas de Informação</a></h3>


<font size="+12"><center>
*Sistema LGJV*
</center></font> 



**Conteúdo**

- [Autores](#autores)
- [Descrição do projeto](#descrição-do-projeto)
- [Diagrama de casos de uso](#diagrama-de-casos-de-uso)
- [Descrição dos casos de uso](#descrição-dos-casos-de-uso)
- [Protótipos de tela](#protótipos-de-tela)
- [Modelo de domínio](#modelo-de-domínio)
- [Decisões de arquitetura](#decisões-de-arquitetura)
- [Referências](#referências)


# Autores

* Gabriel Gimenez
* Joao Pedro
* Vinicius Lima
* Lucca

# Descrição do projeto



*Um projeto de sistema de controle de faltas tem como objetivo principal auxiliar instituições de ensino no registro e controle da frequência dos alunos em aulas e atividades escolares. O sistema deve permitir que os professores e responsáveis possam registrar as faltas dos alunos, incluindo informações sobre a data, horário e motivo da ausência.*


# Diagrama de casos de uso

![WhatsApp Image 2023-04-28 at 23 38 54](https://user-images.githubusercontent.com/100170755/235280263-f13e4d31-7af0-496f-ba2e-6b08a16c6377.jpeg)


# Descrição dos casos de uso

*Registrar Falta: Permite aos professores ou responsáveis registrar faltas de alunos em uma determinada disciplina ou curso.
Consultar Faltas: Permite aos professores, responsáveis ou alunos visualizar informações sobre as faltas registradas, como datas, motivos e número total de faltas acumuladas.
Editar Falta: Permite aos professores ou responsáveis editar informações sobre uma falta registrada anteriormente, como a data ou motivo da ausência.
Excluir Falta: Permite aos professores ou responsáveis excluir uma falta registrada anteriormente.*

# Protótipos de tela

*![Prototipo](https://user-images.githubusercontent.com/100170755/220773601-93b44381-1024-4012-a4fc-2e32e2e85c4f.png)*
*![pt2](https://user-images.githubusercontent.com/100170755/220774153-834ef2e1-be61-41f3-bdfd-349b8922922d.png)*

# Modelo de domínio

*![Dominio](https://user-images.githubusercontent.com/100170755/221247494-563cc0e8-833d-4b1a-9ec8-c051aa13f862.png)*

# Decisões de arquitetura
Este projeto é uma aplicação web que foi feito no front-end com HTML, CSS e JavaScript para criar a interface do usuário e no back-end com Java com SpringBoot framework e arquitetura MVC (Model-View-Controller) para criar a lógica do servidor e interagir com a base de dados, o controlador é implementado em Java com o SpringBoot framework.

Para enviar as requisições do cliente para o servidor, a aplicação utiliza a Fetch API nativa do JavaScript. Isso permite que a comunicação entre o front-end e o back-end seja realizada de forma assíncrona, sem a necessidade de atualizar a página inteira sempre que uma ação é executada.

Em resumo, este projeto é uma aplicação web que utiliza uma combinação de tecnologias front-end e back-end para criar uma interface de usuário interativa e dinâmica que se comunica com o servidor de forma eficiente e rápida.
 


![Arquitetura](https://user-images.githubusercontent.com/100170755/221261944-670d5623-f71a-4bcb-a5b6-f6a427906fce.png)



# Referências

https://www.lucidchart.com/pages/pt/diagrama-de-caso-de-uso-uml
https://www.ic.unicamp.br/~ariadne/mc436/1s2017/Lar10ModDom.pdf
