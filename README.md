# DesafioProfissional
Trabalho da faculdade. Crud feito em Java com conexão para o mongoDB.

Realizei o trabalho tendo em foco seguir minimamente uma arquitetura de projeto MVC (Model, View, Controller) e também adicionei a camada de conexão com o banco (Repository). Este é só um começo de um protótipo em java que realiza cadastros a partir da tela do administrador.

É um projeto simples utilizando o Jframe integrado do NetBeans. 
Seguem todas as dependencias do trabalho para quem quiser replicar.


![image](https://github.com/Julio-Pupim/DesafioProfissional/assets/11467865/5977c667-47bf-40f3-aad7-fe988c87231a)

Lombok para facilitar a construçãod e getters and setters com a anotação @Data, @Getter, @Setter
JDK do java 19
MongoDB driver para conexão com o banco e demais funcionalidades referentes ao banco
Junit para realização de testes no java
Jcalendar para gera um novo JframeSwing que permite trabalhar com datas no projeto de forma facilitada (Tive que converter de java.util.Date para LocalDate)

