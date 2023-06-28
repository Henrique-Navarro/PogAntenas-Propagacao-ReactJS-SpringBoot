<h1>PogAntenas</h1>
<p>PogAntenas é um projeto que visa fornecer uma plataforma para cálculo de parâmetros e topologia de equipamentos de antenas. Com base nos dados dos equipamentos, potência de transmissão e sensibilidade de recepção, atenuação por unidade de comprimento da fibra empregada, perdas por conectores e divisores de potência (power splitter), é possível determinar a distância máxima de um enlace entre OLT (Optical Line Terminal) e ONU (Optical Network Unit).</p>
<h2>Tecnologias utilizadas</h2>
<p>O projeto PogAntenas é desenvolvido utilizando as seguintes tecnologias:</p>
<ul>
  <li>Front-end: ReactJS</li>
  <li>Back-end: Spring Boot</li>
</ul>
<h2>Funcionalidades</h2>
<p>O PogAntenas permite aos usuários:</p>
<ul>
  <li>Inserir os seguintes dados de entrada:</li>
  <ul>
    <li>Potência de transmissão</li>
    <li>Sensibilidade de recepção</li>
    <li>Atenuação por unidade de comprimento da fibra empregada</li>
    <li>Perdas por conectores</li>
    <li>Divisores de potência (power splitter)</li>
    <li>Distância máxima do enlace entre OLT e ONU</li>
  </ul>
  <li>Calcular os valores ausentes com base nos dados fornecidos:</li>
  <ul>
    <li>Caso um ou mais campos estejam faltando, o sistema realiza os cálculos necessários para determinar os valores ausentes.</li>
  </ul>
  <li>Visualizar os resultados calculados:</li>
  <ul>
    <li>Após a realização dos cálculos, o sistema exibe os valores calculados para os parâmetros ausentes.</li>
  </ul>
</ul>
<h2>Arquitetura do projeto</h2>
<p>O projeto PogAntenas segue uma arquitetura baseada no modelo MVC (Model-View-Controller), que separa as responsabilidades em diferentes camadas.</p>
<ul>
  <li>Controller: Responsável por receber as requisições dos usuários e chamar os métodos apropriados do serviço para processar essas requisições.</li>
  <li>Service: Contém a lógica de negócio e realiza os cálculos dos parâmetros ausentes com base nos dados fornecidos.</li>
  <li>Model: Representa a estrutura dos dados utilizados no projeto, nesse caso, a classe Pon contendo os campos necessários para o cálculo dos parâmetros.</li>
  <li>View (Front-end): Desenvolvida em ReactJS, é responsável pela interface do usuário, exibindo os campos de entrada e os resultados calculados.</li>
</ul>
<h2>Como executar o projeto</h2>
<p>Siga as instruções abaixo para executar o projeto PogAntenas em sua máquina:</p>
<ol>
  <li>Certifique-se de ter o Node.js e o Java instalados em sua máquina.</li>
  <li>Faça o clone deste repositório para o seu ambiente local.</li>
  <li>Acesse o diretório <code>front-end</code> e execute o comando <code>npm install</code> para instalar as dependências do front-end.</li>
  <li>Em seguida, execute o comando <code>npm start</code> para iniciar o servidor de desenvolvimento do ReactJS.</li>
  <li>Acesse o diretório <code>backend</code> e execute o comando <code>./mvnw spring-boot:run</code> para iniciar o servidor do Spring Boot.</li>
  <li>Após executar os passos acima, acesse <a href="http://localhost:8080">http://localhost:8080</a> em seu navegador para acessar a aplicação PogAntenas.</li>
</ol>
<h2>Conclusão</h2>
<p>O projeto PogAntenas é uma plataforma que facilita o cálculo de parâmetros e topologia de equipamentos de antenas. Ao fornecer os dados necessários, o sistema é capaz de calcular os valores ausentes e exibir os resultados de forma rápida e eficiente. A combinação das tecnologias ReactJS e Spring Boot proporciona uma experiência de desenvolvimento moderna e escalável. Fique à vontade para explorar e utilizar o PogAntenas em seus projetos relacionados a antenas e redes ópticas.</p>
