# Academia Vitality 

## Arquitetura do Projeto
<div>
  <img src="https://github.com/vitorvhsilva/vitality/blob/main/assets/vitality.drawio.png?raw=true">
</div>

## Resumo do Projeto
Este projeto arquitetado em microsserviços visa simular uma academia que busca trazer a melhor tecnologia do mercado para seus clientes. 
A plataforma permite a gestão completa de usuários e pagamentos, incluindo um sistema de planos de assinatura, que possui 3 níveis:
- Gratuita (Recebe anúncios na interface)
- Premium (Não recebe anúncios)
- Premium Plus (Não recebe anúncios + tem acesso a Vitality IA)

Para os assinantes Premium Plus, através de três modelos de Inteligência Artificial distintos, o sistema gera planos de treino sob medida. O usuário define a meta de calorias a queimar na semana, e a IA responde com um plano detalhado, incluindo:

- Modalidade do exercício: Indica o tipo de treino mais adequado para alcançar o objetivo.
- Duração das sessões: Define o tempo ideal de cada treino.
- Frequência semanal: Estabelece a quantidade de dias por semana que o usuário deve se dedicar aos exercícios.

Essa abordagem permite oferecer uma experiência de treino altamente personalizada e eficaz, atendendo às necessidades individuais de cada cliente.

## Tecnologias e Dependências Utilizadas 
- Java
- Kotlin
- Spring Framework (AMQP, Open Feign, Web, JPA, Validation)
- Python (Flask, Pandas, Matplotlib, NumPy, Seaborn, Sklearn)
- RabbitMQ
- PostgreSQL
- MongoDB
- Docker
  
