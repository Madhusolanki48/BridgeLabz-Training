package com.example.fundoonotes.messaging;

import com.example.fundoonotes.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NoteShareEventProducer {
    private final RabbitTemplate rabbitTemplate;

    public NoteShareEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // UC-10: Publish note-sharing events through RabbitMQ exchange routing
    public void sendNoteSharedEvent(int noteId, String ownerEmail, String collaboratorEmail) {
        String message = "noteId=%d, owner=%s, collaborator=%s"
                .formatted(noteId, ownerEmail, collaboratorEmail);
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.NOTES_EXCHANGE,
                RabbitMQConfig.NOTE_SHARED_ROUTING_KEY,
                message
        );
    }
}
