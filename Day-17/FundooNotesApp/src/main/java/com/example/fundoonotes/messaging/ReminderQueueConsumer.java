package com.example.fundoonotes.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReminderQueueConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ReminderQueueConsumer.class);

    // UC-8: Consume reminder from JMS queue
    @JmsListener(destination = ReminderQueueProducer.REMINDER_QUEUE)
    public void process(ReminderMessage message) {
        logger.info("Reminder queued for note {} of {} at {}",
                message.noteId(), message.email(), message.reminderTime());
    }
}
