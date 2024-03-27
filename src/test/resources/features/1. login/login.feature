#language:pt

@login
Funcionalidade: Acesso ao sistema

  Contexto:
    Dado que esteja na pagina inicial

  @username-invalido
  Cenario: Login sem informar o username
    Quando informar os dados de login sem informar o usuario
    Entao deve exibir mensagem de erro informando que o username e obrigatorio

  @password-invalido
  Cenario: Login sem informar o password
    Quando informar os dados de login sem informar a senha
    Entao deve exibir mensagem de erro informando que o password e obrigatorio

  @username-bloqueado
  Cenario: Login com usuario bloqueado
    Quando informar os dados de login de um usuario bloqueado
    Entao deve exibir mensagem de erro informando que o usuario esta bloqueado

  @login-incorreto
  Cenario: Login incorreto
    Quando informar os dados de login
    Entao deve exibir mensagem de erro informando que o usuario e senha estão incorretos


  @login-sucesso
  Cenario: Realizar login na pagina inicial do sistema
    Quando informar login valido
    Entao deve apresentar a tela inicial do sistema
