package com.example.fundoonotes.messaging;

import com.example.fundoonotes.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CollaboratorNotifyConsumer {
    private static final Logger logger = LoggerFactory.getLogger(CollaboratorNotifyConsumer.class);

    // UC-10: Consumer for collaborator notification messages
    @RabbitListener(queues = RabbitMQConfig.COLLABORATOR_NOTIFY_QUEUE)
    public void notifyCollaborator(String message) {
        logger.info("RabbitMQ collaborator notification event: {}", message);
    }
}
