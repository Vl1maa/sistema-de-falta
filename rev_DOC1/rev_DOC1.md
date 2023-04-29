

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

![Caso de Uso](https://user-images.githubusercontent.com/100170755/220771904-bcc959ec-b779-464f-bf37-63fad16b0a01.png)*

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

* A arquitetura para o sistema de controle de faltas pode ser a arquitetura em três camadas (apresentação, negócio e dados), na qual a camada de apresentação é responsável pela interface do usuário, a camada de negócio pela lógica de negócio do sistema e a camada de dados pelo armazenamento e recuperação dos dados do sistema.*

Sistema de registro de frequência: o sistema de registro de frequência permite que os professores ou instrutores registrem a presença ou ausência dos alunos em cada aula ou atividade educacional. Isso pode ser feito por meio de um sistema eletrônico de leitura de cartão de presença ou por meio de um sistema de registro manual.

Banco de dados: o banco de dados é onde as informações sobre as faltas dos alunos são armazenadas. Ele pode incluir informações sobre o número de faltas, o tipo de falta (justificada ou não justificada), o motivo da falta, entre outras.

Sistema de notificação: o sistema de notificação pode enviar alertas para os pais ou responsáveis quando um aluno falta à aula ou atividade educacional. Isso pode ajudar a garantir que os pais ou responsáveis tomem medidas adequadas para gerenciar as ausências dos alunos.

Ferramentas de relatórios: as ferramentas de relatórios permitem que os professores ou instrutores gerem relatórios sobre as faltas dos alunos, incluindo informações sobre o número de faltas e padrões de ausência. Esses relatórios podem ser úteis para identificar alunos que precisam de intervenção ou apoio adicional.






![Arquitetura](https://user-images.githubusercontent.com/100170755/221261944-670d5623-f71a-4bcb-a5b6-f6a427906fce.png)



# Referências

https://www.lucidchart.com/pages/pt/diagrama-de-caso-de-uso-uml
https://www.ic.unicamp.br/~ariadne/mc436/1s2017/Lar10ModDom.pdf
