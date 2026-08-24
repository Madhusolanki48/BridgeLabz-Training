package com.example.fundoonotes.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReminderQueueProducer {
    public static final String REMINDER_QUEUE = "note-reminder-queue";
    private final JmsTemplate jmsTemplate;

    public ReminderQueueProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    // UC-8: Send reminder through JMS
    public void send(ReminderMessage message) {
        jmsTemplate.convertAndSend(REMINDER_QUEUE, message);
    }
}
