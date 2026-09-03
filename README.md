## 📖 Sobre o Projeto

Esse projeto é um serviço que gerencia um carrinho de compras simples, integrando dados de uma API externa para fornecer produtos disponíveis. Ele utiliza uma arquitetura eficiente que combina cache (Redis), banco de dados NoSQL (MongoDB), e contêineres (Docker), garantindo alta performance e escalabilidade e foi desenvolvido em conjunto com o estudo de caching no Java10x.

### Principais Objetivos:
- Oferecer uma experiência fluida ao usuário.
- Minimizar chamadas desnecessárias à API externa através do cache.
- Facilitar o deploy em ambientes containerizados.

---

## 🛠 Tecnologias Utilizadas

O projeto foi desenvolvido com as seguintes tecnologias:

### Java 21
- Linguagem principal do projeto, focada em desempenho e funcionalidades aprimoradas.
- Saiba mais: [Documentação oficial do Java](https://openjdk.org/projects/jdk/17/)

### Lombok
- Reduz a verbosidade do código, automatizando a criação de getters, setters e construtores.
- Saiba mais: [Documentação oficial do Lombok](https://projectlombok.org/)

### Redis
- Um banco de dados em memória, utilizado como cache para melhorar a performance nas interações com a API externa.
- Saiba mais: [Introdução ao Redis](https://redis.io/docs/)

### MongoDB
- Banco de dados NoSQL, utilizado para armazenar as informações do carrinho de compras de maneira flexível.
- Saiba mais: [Documentação oficial do MongoDB](https://www.mongodb.com/docs/)

### OpenFeign
- Uma biblioteca que simplifica a integração com APIs externas, tornando a comunicação mais intuitiva e reduzindo a verbosidade do código.
- Saiba mais: [Documentação oficial do OpenFeign](https://github.com/OpenFeign/feign)

### Docker
- Ferramenta de containerização para criar ambientes consistentes e simplificados para deploy.
- Saiba mais: [Documentação oficial do Docker](https://docs.docker.com/)

### API Externa
- Integração com uma API que fornece a lista de produtos disponíveis para o carrinho.
- Saiba mais sobre integração com APIs: [Guia para trabalhar com APIs](https://www.postman.com/api-documentation/)

---

## ✨ Funcionalidades

- **Listar Produtos**: Gerencie os produtos do carrinho de forma simples.
- **Criar, Alterar, Pagar e Deletar**: Gerencie o carrinho de compras.
- **Cache Inteligente**: Reduz o tempo de resposta com dados armazenados no Redis.
- **Persistência com MongoDB**: Armazene os dados do carrinho com segurança e flexibilidade.
- **Integração com API Externa**: Produtos são carregados diretamente de uma API confiável.
- **Suporte Docker**: Implante o projeto rapidamente em qualquer ambiente.
