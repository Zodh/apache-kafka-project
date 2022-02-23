# Descrição geral de funcionamento 

- O producer é quem grava;
- O consumer é quem lê e toma alguma ação com base na mensagem gravada;

---

### O kafka é o broker de mensagem - inteligencia do controle do recebimento e controle da mensagem;

## O kafka é dividido entre topicos e particões:

- A quantidade de particões indica quantos consumers podem ler o kafka simultaneamente;
- Quando o producer manda uma mensagem, ela não precisa ser lida instantaneamente, ela fica guardada;
- Todo consumer deve avisar ao Kafka que processou a mensagem recebida, caso contrário, continuará recebendo a mensagem - offset;
- Os consumidores são separados por grupos de consumo (groupId);
- Uma mensagem é entregue uma única vez para cada grupo de consumo (groupId);

- Quando temos apenas um grupo de consumo, é uma fila. Neste caso, você PODE ter mais de uma partição, mas as mensagens serão distribuidas entre elas.

- Quando temos mais que um grupo de consumo, se torna tópico. Quando é um tópico, a mesma mensagem é entregue para cada grupo de consumo (groupId);

## O Apache ZooKeeper 
- Gerencia as instâncias disponíveis em um cluster;
- Mantém o relacionamento e a distribuição das partições;

