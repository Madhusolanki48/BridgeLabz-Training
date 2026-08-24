package com.example.fundoonotes.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String NOTES_EXCHANGE = "notes-exchange";
    public static final String NOTE_SHARED_ROUTING_KEY = "note.shared";
    public static final String COLLABORATOR_NOTIFY_QUEUE = "collaborator-notify-queue";
    public static final String ACTIVITY_LOG_QUEUE = "note-activity-log-queue";

    @Bean
    public TopicExchange notesExchange() {
        return new TopicExchange(NOTES_EXCHANGE);
    }

    @Bean
    public Queue collaboratorNotifyQueue() {
        return new Queue(COLLABORATOR_NOTIFY_QUEUE);
    }

    @Bean
    public Queue activityLogQueue() {
        return new Queue(ACTIVITY_LOG_QUEUE);
    }

    @Bean
    public Binding collaboratorNotifyBinding(Queue collaboratorNotifyQueue, TopicExchange notesExchange) {
        return BindingBuilder.bind(collaboratorNotifyQueue)
                .to(notesExchange)
                .with(NOTE_SHARED_ROUTING_KEY);
    }

    @Bean
    public Binding activityLogBinding(Queue activityLogQueue, TopicExchange notesExchange) {
        return BindingBuilder.bind(activityLogQueue)
                .to(notesExchange)
                .with(NOTE_SHARED_ROUTING_KEY);
    }
}
