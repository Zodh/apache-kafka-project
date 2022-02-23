# Como rodar o Apache Kafka

1. Abra o site do Docker Hub e [busque pelo Kafka](https://hub.docker.com/search?q=kafka&type=image);
2. Crie um docker-compose.yml para puxar a imagem docker do Kafka para o repositório desejado:

```yaml
version: "3"
services:
  zookeeper:
    image: 'bitnami/zookeeper:latest'
    ports:
      - '2181:2181'
    environment:
      - ALLOW_ANONYMOUS_LOGIN=yes
  kafka:
    image: 'bitnami/kafka:latest'
    ports:
      - '9092:9092'
    environment:
      - KAFKA_BROKER_ID=1
      - KAFKA_CFG_LISTENERS=PLAINTEXT://:9092
      - KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://127.0.0.1:9092
      - KAFKA_CFG_ZOOKEEPER_CONNECT=zookeeper:2181
      - ALLOW_PLAINTEXT_LISTENER=yes
    depends_on:
      - zookeeper
``` 
> Este arquivo deve ser configurado para suas necessidades!

> O Kafka possui uma interface gráfica, mas para propósitos profissionais, ele é pago. E caro. https://www.kafkatool.com/

3. Execute o comando `docker-compose up -d`;

Pronto. Kafka rodando com sucesso! ;)
