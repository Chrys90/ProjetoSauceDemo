#language:pt

@login
Funcionalidade: Acesso ao sistema

  Contexto:
    Dado que esteja na pagina inicial

  @usernameInvalido
  Cenario: Login sem informar o username
    Quando informar os dados de login sem informar o usuario
    Entao deve exibir mensagem de erro informando que o username e obrigatorio

  @passwordInvalido
  Cenario: Login sem informar o password
    Quando informar os dados de login sem informar a senha
    Entao deve exibir mensagem de erro informando que o password e obrigatorio

  @usernameBloqueado
  Cenario: Login com usuario bloqueado
    Quando informar os dados de login de um usuario bloqueado
    Entao deve exibir mensagem de erro informando que o usuario esta bloqueado

  @loginIncorreto
  Cenario: Login incorreto
    Quando informar os dados de login
    Entao deve exibir mensagem de erro informando que o usuario e senha estão incorretos


  @loginComSucesso
  Cenario: Realizar login na pagina inicial do sistema
    Quando informar login valido
    Entao deve apresentar a tela inicial do sistema
