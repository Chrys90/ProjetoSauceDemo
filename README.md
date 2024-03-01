# Projeto prático n° 1

Projeto desenvolvido utilizando Java, Junit, Cucumber e Selenium

# Pré-Requisitos 

Realizar a instalação:
- Oracle JDK 8
- Maven
- InteliJ IDEA Community Edition
- Setar JAVA_HOME, MAVEN_HOME

## Entendendo o projeto de automação:

Projeto desenvolvido com o intuito de prática num fluxo de teste E2E, no qual inicia pelo acesso a página(login) e simula um fluxo de compra de produtos na página.

Estrutura de pastas (src > test > java > br.com.funcionalidades):
- page – ações dos componentes, todas as ações lógicas devem estar dentro desta classe. 
- maps – páginas que vão mapear os elementos da classe.
- steps - classe onde é feita a ligação entre os passos executados durante o teste com as ações configuradas na page.

## Executando os Testes

Testes podem ser executados através da classe RunnerTest localizada no caminho : (src > test > java > br.com.funcionalidades > runner > RunnerTest) 
Para executar os cenários de teste individualmente basta informar a tag do cenário informada nos arquivos features, localizada em : (src > test > java > resources > features)
