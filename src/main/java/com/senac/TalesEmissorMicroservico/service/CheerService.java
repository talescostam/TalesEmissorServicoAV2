package com.senac.TalesEmissorMicroservico.service;

import com.senac.TalesEmissorMicroservico.entity.Cheer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheerService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CheerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendCheerMessage(Cheer cheer) {
        rabbitTemplate.convertAndSend("cheermq", cheer);
    }
}
