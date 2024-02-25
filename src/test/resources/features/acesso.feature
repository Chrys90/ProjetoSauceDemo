#language:pt

@login
Funcionalidade: Acesso ao sistema

  @acesso
  Cenario: Realizar login na pagina inicial do sistema
    Dado que esteja na pagina inicial
    Quando informar login valido
    Entao deve apresentar a tela inicial do sistema