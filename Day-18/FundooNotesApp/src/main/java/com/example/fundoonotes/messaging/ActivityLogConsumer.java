package com.example.fundoonotes.messaging;

import com.example.fundoonotes.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ActivityLogConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ActivityLogConsumer.class);

    // UC-10: Second consumer proves producer is decoupled from queue subscribers
    @RabbitListener(queues = RabbitMQConfig.ACTIVITY_LOG_QUEUE)
    public void logActivity(String message) {
        logger.info("RabbitMQ activity log event: {}", message);
    }
}
