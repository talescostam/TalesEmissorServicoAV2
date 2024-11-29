package com.senac.TalesEmissorMicroservico.config;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMQConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;
    private Queue queue;

    private Queue queue (String queueName){
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange createDirectExchange(){
        return new DirectExchange("cheermq");
    }

    @PostConstruct
    private void Create (){
        this.queue = new Queue("cheermq");

        // Create the direct exchange
        DirectExchange directExchange = createDirectExchange();

        // Create the binding
        Binding binding = new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);

        amqpAdmin.declareQueue(queue);
        amqpAdmin.declareExchange(directExchange);
        amqpAdmin.declareBinding(binding);
    }

}
