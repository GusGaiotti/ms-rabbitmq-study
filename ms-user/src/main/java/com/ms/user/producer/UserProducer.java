package com.ms.user.producer;

import com.ms.user.config.RabbitMQConfig;
import com.ms.user.dto.EmailRequestDto;
import com.ms.user.dto.UserRequestDTO;
import com.ms.user.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user){
        EmailRequestDto emailRequestDto = new EmailRequestDto(
                user.getUserId(),
                user.getEmail(),
                "Cadastro realizado",
                user.getName() + " - Seja Bem-Vindo!"
        );

        rabbitTemplate.convertAndSend("", routingKey, emailRequestDto);

    }
}
