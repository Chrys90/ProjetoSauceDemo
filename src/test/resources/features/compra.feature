#language:pt
@compras
Funcionalidade: Compra de produto

  @carrinhoDeCompras
  Cenario: Adicionar produto no carrinho de compras
    Dado que esteja na pagina de produtos
    Quando clicar em um produto
    Entao o produto deve ser incluido no carrinho de compras

  @checkout
  Cenario: Realizar checkout do produto
    Dado que esteja na tela do carrinho de compras
    Quando clicar em checkout
    Entao deve ser apresentado a tela para incluir informacoes do cliente

   @informacoesCliente
  Cenario: Incluir informacoes do cliente no pedido
    Dado que esteja na tela de informacoes do cliente
    Quando preencher as informacoes e clicar em Continue
    Entao deve ser apresentado a tela de confirmacao do pedido
  @finalizarCompra
  Cenario: Finalizar compra do cliente
    Dado que estja na tela de confirmacao do pedido
    Quando clicar em Finish
    Entao deve ser apresentado a mensagem de confirmacao do pedido