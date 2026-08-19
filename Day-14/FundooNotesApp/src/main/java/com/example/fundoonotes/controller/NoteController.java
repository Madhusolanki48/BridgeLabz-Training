package com.example.fundoonotes.controller;

import com.example.fundoonotes.dto.NoteRequest;
import com.example.fundoonotes.dto.NoteResponse;
import com.example.fundoonotes.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(@Valid @RequestBody NoteRequest request,
                                                   Authentication authentication) {
        NoteResponse response = noteService.createNote(request, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getAllNotes(Authentication authentication) {
        return ResponseEntity.ok(noteService.getAllNotes(authentication.getName()));
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteResponse> getNoteById(@PathVariable int noteId,
                                                    Authentication authentication) {
        return ResponseEntity.ok(noteService.getNoteById(noteId, authentication.getName()));
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<NoteResponse> updateNote(@PathVariable int noteId,
                                                   @Valid @RequestBody NoteRequest request,
                                                   Authentication authentication) {
        return ResponseEntity.ok(noteService.updateNote(noteId, request, authentication.getName()));
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable int noteId,
                                             Authentication authentication) {
        return ResponseEntity.ok(noteService.deleteNote(noteId, authentication.getName()));
    }

    @PutMapping("/{noteId}/archive")
    public ResponseEntity<NoteResponse> archiveNote(@PathVariable int noteId,
                                                    Authentication authentication) {
        return ResponseEntity.ok(noteService.archiveNote(noteId, authentication.getName()));
    }
}
