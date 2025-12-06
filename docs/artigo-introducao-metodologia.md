# Introdução

A crescente complexidade dos sistemas de informação e a necessidade de respostas rápidas e confiáveis têm impulsionado
o uso de interfaces web cada vez mais ricas e interativas. Em um contexto em que os usuários finais demandam experiências
intuitivas, responsivas e acessíveis a partir de diferentes dispositivos, a construção de aplicações web que conciliem
usabilidade, desempenho e qualidade de código torna-se um desafio central para equipes de desenvolvimento.

Neste trabalho, é proposta a implementação de uma interface web para um sistema já existente, permitindo a execução das
operações de Create, Read, Update e Delete (CRUD) diretamente no navegador. A solução proposta é complementada por uma
suíte de testes automatizados de interface utilizando Selenium WebDriver, com o objetivo de validar o comportamento da
aplicação em diferentes cenários de uso, incluindo casos positivos e negativos. A automação de testes contribui para a
redução de falhas em produção, aumenta a confiança nas mudanças realizadas e facilita a evolução incremental do sistema.

Diversos autores destacam a relevância da automação de testes para garantir a qualidade de software, especialmente em
aplicações web que sofrem alterações frequentes na camada de apresentação. Trabalhos que discutem técnicas de teste de
interface gráfica e o uso de ferramentas de automação para simular o comportamento do usuário fornecem a base teórica
que sustenta a abordagem adotada neste projeto. Além disso, são considerados princípios de engenharia de software, como
Clean Code, coesão, baixo acoplamento e reutilização de componentes, de forma a produzir um código organizado, legível
e de fácil manutenção.

O projeto também enfatiza o uso de padrões de projeto na camada de testes, em especial o padrão Page Object Model (POM),
que auxilia na separação de responsabilidades ao encapsular a lógica de interação com a interface em classes específicas
para cada página. Dessa forma, alterações na estrutura visual da aplicação impactam minimamente o código de teste,
contribuindo para a robustez e flexibilidade da solução. Outro ponto relevante é o acompanhamento da cobertura de código,
que permite identificar áreas não exercitadas pelos testes e orientar a criação de novos casos de teste.

Por fim, este trabalho visa demonstrar, por meio de um estudo prático, como a combinação de uma interface web bem projetada
com uma estratégia sólida de automação de testes pode resultar em um sistema mais confiável, escalável e fácil de evoluir,
atendendo tanto às necessidades dos usuários finais quanto às demandas de qualidade exigidas pelas organizações.

# Metodologia

A metodologia adotada neste trabalho é de natureza aplicada, com foco na implementação prática e na avaliação de uma
solução de software que integra uma interface web e uma suíte de testes automatizados de interface. O processo metodológico
pode ser dividido em quatro etapas principais: (1) análise do sistema existente, (2) projeto e implementação da interface
web, (3) projeto e implementação dos testes automatizados com Selenium WebDriver e (4) avaliação da qualidade e cobertura
dos testes.

Na primeira etapa, é realizada a análise do sistema existente, identificando-se as operações CRUD que já estão disponíveis
na camada de negócio. Nessa fase, são levantados os requisitos funcionais e não funcionais relevantes para a nova interface
web, considerando aspectos como usabilidade, responsividade, clareza na navegação e tratamento de erros. Também são
identificados os fluxos de uso mais importantes para os usuários, que servirão como base para a definição dos casos de teste.

Na segunda etapa, é elaborado o projeto da interface web utilizando princípios de engenharia de software e boas práticas de
desenvolvimento front-end. São definidas as rotas da aplicação, as páginas responsáveis pelo cadastro, listagem, edição e
exclusão de registros, bem como os componentes de formulário e tabelas de listagem. A implementação é realizada com o apoio
de um framework web (por exemplo, Spring Boot com Thymeleaf), garantindo a integração com a camada de serviço já existente.
Durante essa etapa, são adotados padrões de projeto e convenções de codificação que favoreçam a legibilidade, a manutenibilidade
e a reutilização de componentes.

A terceira etapa consiste na definição e implementação da suíte de testes automatizados utilizando Selenium WebDriver
integrado ao framework de testes JUnit. Inicialmente, é escolhido o padrão Page Object Model (POM) para estruturar o código
de teste, criando-se classes de página que representam cada tela da aplicação e encapsulam as operações de interação com
a interface (como clique em botões, preenchimento de campos de formulário e leitura de dados em tabelas). Em seguida, são
desenvolvidos casos de teste que cobrem o fluxo completo das operações CRUD, bem como cenários alternativos e negativos,
incluindo entradas inválidas e simulação de falhas. Sempre que possível, são utilizados testes parametrizados para validar
diferentes entradas de dados de forma sistemática e reduzir duplicação de código.

Na quarta etapa, é realizada a avaliação da qualidade dos testes e da aplicação como um todo. Ferramentas de cobertura de
código, como JaCoCo, são integradas ao processo de build para medir o percentual de código exercitado pelos testes
automatizados. A meta estabelecida é uma cobertura mínima de 80%, incluindo não apenas os cenários de sucesso, mas também
tratamentos de erro e comportamentos inesperados. Com base nos relatórios de cobertura, são identificados pontos cegos
no conjunto de testes e, quando necessário, são criados novos casos para ampliar a abrangência. Além disso, são analisadas
boas práticas de código, como clareza na nomeação de variáveis e métodos, coesão das classes, baixo acoplamento e uso
adequado de tipos de dados.

Ao final do processo, a solução implementada é discutida à luz dos objetivos do trabalho e dos referenciais teóricos
consultados, destacando-se os benefícios e limitações da abordagem adotada. Essa análise permite não apenas validar a
eficácia da combinação entre interface web e automação de testes, como também oferecer recomendações para trabalhos
futuros e para a evolução do sistema em contextos reais de desenvolvimento de software.
