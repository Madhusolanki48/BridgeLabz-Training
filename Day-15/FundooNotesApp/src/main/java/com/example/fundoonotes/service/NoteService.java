package com.example.fundoonotes.service;

import com.example.fundoonotes.dto.NoteRequest;
import com.example.fundoonotes.dto.NoteResponse;
import com.example.fundoonotes.entity.Note;
import com.example.fundoonotes.entity.NoteLabel;
import com.example.fundoonotes.entity.User;
import com.example.fundoonotes.exception.InvalidNoteStateException;
import com.example.fundoonotes.exception.InvalidCredentialsException;
import com.example.fundoonotes.exception.LabelNotFoundException;
import com.example.fundoonotes.exception.NoteNotFoundException;
import com.example.fundoonotes.repository.NoteLabelRepository;
import com.example.fundoonotes.repository.NoteRepository;
import com.example.fundoonotes.repository.UserRepository;
import com.example.fundoonotes.specification.NoteSpecification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteLabelRepository noteLabelRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository,
                       NoteLabelRepository noteLabelRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.noteLabelRepository = noteLabelRepository;
    }

    // UC-1: Add note for logged-in user
    public NoteResponse createNote(NoteRequest request, String email) {
        User user = getUser(email);

        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        updateExtraFields(note, request);
        note.setUser(user);

        return mapToResponse(noteRepository.save(note));
    }

    // UC-2: Get all active notes of logged-in user
    public List<NoteResponse> getAllNotes(String email) {
        return noteRepository.findByUser_EmailAndArchivedFalseAndTrashedFalse(email)
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
        updateExtraFields(note, request);
        return mapToResponse(noteRepository.save(note));
    }

    // UC-5: Move note to trash
    public String deleteNote(int noteId, String email) {
        Note note = getNote(noteId, email);
        note.setTrashed(true);
        note.setPined(false);
        noteRepository.save(note);
        return "Note moved to trash successfully";
    }

    // UC-6: Archive or unarchive note
    public NoteResponse archiveNote(int noteId, String email) {
        Note note = getNote(noteId, email);
        note.setArchived(!note.isArchived());
        if (note.isArchived()) {
            note.setPined(false);
        }
        return mapToResponse(noteRepository.save(note));
    }

    // UC-7: Pin or unpin note
    public NoteResponse pinNote(int noteId, String email) {
        Note note = getNote(noteId, email);
        if (note.isTrashed()) {
            throw new InvalidNoteStateException("Cannot pin a trashed note");
        }
        note.setPined(!note.isPined());
        return mapToResponse(noteRepository.save(note));
    }

    // UC-8: Get archived notes
    public List<NoteResponse> getArchiveNotes(String email) {
        return noteRepository.findByUser_EmailAndArchivedTrueAndTrashedFalse(email)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // UC-9: Get trash notes
    public List<NoteResponse> getTrashNotes(String email) {
        return noteRepository.findByUser_EmailAndTrashedTrue(email)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // UC-10: Delete note permanently
    public String deleteForever(int noteId, String email) {
        Note note = getNote(noteId, email);
        if (!note.isTrashed()) {
            throw new InvalidNoteStateException("Move note to trash before deleting forever");
        }
        noteRepository.delete(note);
        return "Note deleted permanently";
    }

    // UC-11: Add label to note
    public NoteResponse addLabelToNote(int noteId, int labelId, String email) {
        Note note = getNote(noteId, email);
        NoteLabel label = getLabel(labelId, email);
        note.getLabels().add(label);
        return mapToResponse(noteRepository.save(note));
    }

    // UC-12: Remove label from note
    public NoteResponse removeLabelFromNote(int noteId, int labelId, String email) {
        Note note = getNote(noteId, email);
        NoteLabel label = getLabel(labelId, email);
        note.getLabels().remove(label);
        return mapToResponse(noteRepository.save(note));
    }

    // UC-13: Search and filter notes
    public List<NoteResponse> searchNotes(String title, String state, String label, String email) {
        return noteRepository.findAll(NoteSpecification.search(email, title, state, label))
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // UC-14: Get notes by label
    public List<NoteResponse> getNotesByLabel(String label, String email) {
        return noteRepository.findByUser_EmailAndLabels_LabelAndLabels_DeletedFalseAndTrashedFalse(email, label)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("User not found!"));
    }

    private Note getNote(int noteId, String email) {
        return noteRepository.findByNoteIdAndUser_Email(noteId, email)
                .orElseThrow(() -> new NoteNotFoundException("Note not found!"));
    }

    private NoteLabel getLabel(int labelId, String email) {
        return noteLabelRepository.findByIdAndUser_EmailAndDeletedFalse(labelId, email)
                .orElseThrow(() -> new LabelNotFoundException("Label not found!"));
    }

    private void updateExtraFields(Note note, NoteRequest request) {
        note.setColor(request.getColor());
        note.setTypeOfNote(request.getTypeOfNote());
        note.setImageUrl(request.getImageUrl());
        note.setLinkUrl(request.getLinkUrl());
    }

    private NoteResponse mapToResponse(Note note) {
        Set<String> labels = note.getLabels()
                .stream()
                .filter(label -> !label.isDeleted())
                .map(NoteLabel::getLabel)
                .collect(Collectors.toSet());

        return new NoteResponse(
                note.getNoteId(),
                note.getTitle(),
                note.getDescription(),
                note.isPined(),
                note.isArchived(),
                note.isTrashed(),
                note.getColor(),
                note.getTypeOfNote(),
                note.getImageUrl(),
                note.getLinkUrl(),
                labels
        );
    }
}
