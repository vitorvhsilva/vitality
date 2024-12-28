package br.com.vitality.payments_service.api.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {
    @Bean
    fun criarFila(): Queue {
        return Queue("payment.made.queue", false)
    }

    @Bean
    fun criaRabbitAdmin(conn: ConnectionFactory): RabbitAdmin {
        return RabbitAdmin(conn)
    }

    @Bean
    fun inicializaAdmin(rabbitAdmin: RabbitAdmin): ApplicationListener<ApplicationReadyEvent> {
        return ApplicationListener { event: ApplicationReadyEvent -> rabbitAdmin.initialize() }
    }

    @Bean
    fun messageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun rabbitTemplate(
        connectionFactory: ConnectionFactory,
        jackson2JsonMessageConverter: Jackson2JsonMessageConverter
    ): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = jackson2JsonMessageConverter
        return rabbitTemplate
    }
}