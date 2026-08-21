package com.example.fundoonotes.messaging;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ReminderMessage(int noteId, String email, LocalDateTime reminderTime) implements Serializable {
}
