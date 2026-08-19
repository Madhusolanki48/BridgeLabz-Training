package com.example.fundoonotes.service;

import com.example.fundoonotes.dto.NoteRequest;
import com.example.fundoonotes.dto.NoteResponse;
import com.example.fundoonotes.entity.Note;
import com.example.fundoonotes.entity.User;
import com.example.fundoonotes.exception.InvalidCredentialsException;
import com.example.fundoonotes.exception.NoteNotFoundException;
import com.example.fundoonotes.repository.NoteRepository;
import com.example.fundoonotes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    // UC-1: Add note for logged-in user
    public NoteResponse createNote(NoteRequest request, String email) {
        User user = getUser(email);

        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setUser(user);

        return mapToResponse(noteRepository.save(note));
    }

    // UC-2: Get all active notes of logged-in user
    public List<NoteResponse> getAllNotes(String email) {
        return noteRepository.findByUser_EmailAndTrashedFalse(email)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // UC-3: Get note by id
    public NoteResponse getNoteById(int noteId, String email) {
        return mapToResponse(getNote(noteId, email));
    }

    // UC-4: Update note by id
    public NoteResponse updateNote(int noteId, NoteRequest request, String email) {
        Note note = getNote(noteId, email);
        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        return mapToResponse(noteRepository.save(note));
    }

    // UC-5: Move note to trash
    public String deleteNote(int noteId, String email) {
        Note note = getNote(noteId, email);
        note.setTrashed(true);
        noteRepository.save(note);
        return "Note moved to trash successfully";
    }

    // UC-6: Archive or unarchive note
    public NoteResponse archiveNote(int noteId, String email) {
        Note note = getNote(noteId, email);
        note.setArchived(!note.isArchived());
        return mapToResponse(noteRepository.save(note));
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("User not found!"));
    }

    private Note getNote(int noteId, String email) {
        return noteRepository.findByNoteIdAndUser_Email(noteId, email)
                .orElseThrow(() -> new NoteNotFoundException("Note not found!"));
    }

    private NoteResponse mapToResponse(Note note) {
        return new NoteResponse(
                note.getNoteId(),
                note.getTitle(),
                note.getDescription(),
                note.isArchived(),
                note.isTrashed()
        );
    }
}
