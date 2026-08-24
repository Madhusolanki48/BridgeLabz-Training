package com.example.fundoonotes.controller;

import com.example.fundoonotes.dto.NoteRequest;
import com.example.fundoonotes.dto.NoteResponse;
import com.example.fundoonotes.dto.ReminderRequest;
import com.example.fundoonotes.dto.ShareNoteRequest;
import com.example.fundoonotes.dto.NoteImportResult;
import com.example.fundoonotes.service.NoteExcelBatchService;
import com.example.fundoonotes.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;
    private final NoteExcelBatchService noteExcelBatchService;

    public NoteController(NoteService noteService, NoteExcelBatchService noteExcelBatchService) {
        this.noteService = noteService;
        this.noteExcelBatchService = noteExcelBatchService;
    }

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(@Valid @RequestBody NoteRequest request,
                                                   Authentication authentication) {
        NoteResponse response = noteService.createNote(request, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // UC-4: PDF-style create note endpoint
    @PostMapping("/addNotes")
    public ResponseEntity<NoteResponse> addNotes(@Valid @RequestBody NoteRequest request,
                                                 Authentication authentication) {
        return createNote(request, authentication);
    }

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getAllNotes(Authentication authentication) {
        return ResponseEntity.ok(noteService.getAllNotes(authentication.getName()));
    }

    // UC-4: PDF-style active notes list endpoint
    @GetMapping("/getNotesList")
    public ResponseEntity<List<NoteResponse>> getNotesList(Authentication authentication) {
        return getAllNotes(authentication);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteResponse> getNoteById(@PathVariable int noteId,
                                                    Authentication authentication) {
        return ResponseEntity.ok(noteService.getNoteById(noteId, authentication.getName()));
    }

    // UC-4: PDF-style note details endpoint
    @GetMapping("/getNotesDetail/{noteId}")
    public ResponseEntity<NoteResponse> getNotesDetail(@PathVariable int noteId,
                                                       Authentication authentication) {
        return getNoteById(noteId, authentication);
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

    // UC-5: Pin or unpin a note
    @PutMapping("/{noteId}/pin")
    public ResponseEntity<NoteResponse> pinNote(@PathVariable int noteId,
                                                Authentication authentication) {
        return ResponseEntity.ok(noteService.pinNote(noteId, authentication.getName()));
    }

    // UC-5: PDF-style pin endpoint
    @PostMapping("/pinUnpinNotes")
    public ResponseEntity<NoteResponse> pinUnpinNotes(@RequestParam int noteId,
                                                      Authentication authentication) {
        return pinNote(noteId, authentication);
    }

    // UC-5: PDF-style archive endpoint
    @PostMapping("/archiveNotes")
    public ResponseEntity<NoteResponse> archiveNotes(@RequestParam int noteId,
                                                     Authentication authentication) {
        return archiveNote(noteId, authentication);
    }

    // UC-5: PDF-style trash endpoint
    @PostMapping("/trashNotes")
    public ResponseEntity<String> trashNotes(@RequestParam int noteId,
                                             Authentication authentication) {
        return deleteNote(noteId, authentication);
    }

    // UC-5: List archived notes
    @GetMapping("/getArchiveNotesList")
    public ResponseEntity<List<NoteResponse>> getArchiveNotesList(Authentication authentication) {
        return ResponseEntity.ok(noteService.getArchiveNotes(authentication.getName()));
    }

    // UC-5: List trashed notes
    @GetMapping("/getTrashNotesList")
    public ResponseEntity<List<NoteResponse>> getTrashNotesList(Authentication authentication) {
        return ResponseEntity.ok(noteService.getTrashNotes(authentication.getName()));
    }

    // UC-10: Send note-sharing event through RabbitMQ
    @PostMapping("/{noteId}/share")
    public ResponseEntity<String> shareNote(@PathVariable int noteId,
                                            @Valid @RequestBody ShareNoteRequest request,
                                            Authentication authentication) {
        return ResponseEntity.ok(noteService.shareNote(noteId, request, authentication.getName()));
    }

    // Permanently delete trashed note
    @PostMapping("/deleteForeverNotes")
    public ResponseEntity<String> deleteForeverNotes(@RequestParam int noteId,
                                                     Authentication authentication) {
        return ResponseEntity.ok(noteService.deleteForever(noteId, authentication.getName()));
    }

    // UC-6: Add label to note
    @PostMapping("/{noteId}/addLabelToNotes/{labelId}/add")
    public ResponseEntity<NoteResponse> addLabelToNotes(@PathVariable int noteId,
                                                        @PathVariable int labelId,
                                                        Authentication authentication) {
        return ResponseEntity.ok(noteService.addLabelToNote(noteId, labelId, authentication.getName()));
    }

    // UC-6: Remove label from note
    @PostMapping("/{noteId}/addLabelToNotes/{labelId}/remove")
    public ResponseEntity<NoteResponse> removeLabelFromNotes(@PathVariable int noteId,
                                                             @PathVariable int labelId,
                                                             Authentication authentication) {
        return ResponseEntity.ok(noteService.removeLabelFromNote(noteId, labelId, authentication.getName()));
    }

    // UC-7: Search by title, state, and label
    @GetMapping("/search")
    public ResponseEntity<List<NoteResponse>> searchNotes(@RequestParam(required = false) String title,
                                                          @RequestParam(required = false) String state,
                                                          @RequestParam(required = false) String label,
                                                          Authentication authentication) {
        return ResponseEntity.ok(noteService.searchNotes(title, state, label, authentication.getName()));
    }

    // UC-7: Dedicated label filter endpoint
    @GetMapping("/getNotesListByLabel/{labelName}")
    public ResponseEntity<List<NoteResponse>> getNotesByLabel(@PathVariable String labelName,
                                                              Authentication authentication) {
        return ResponseEntity.ok(noteService.getNotesByLabel(labelName, authentication.getName()));
    }

    // UC-8: Add or update note reminders
    @PostMapping("/addUpdateReminderNotes")
    public ResponseEntity<NoteResponse> addUpdateReminderNotes(@Valid @RequestBody ReminderRequest request,
                                                               Authentication authentication) {
        return ResponseEntity.ok(noteService.addUpdateReminder(request, authentication.getName()));
    }

    // UC-8: Remove note reminders
    @PostMapping("/removeReminderNotes")
    public ResponseEntity<NoteResponse> removeReminderNotes(@Valid @RequestBody ReminderRequest request,
                                                            Authentication authentication) {
        return ResponseEntity.ok(noteService.removeReminder(request, authentication.getName()));
    }

    // UC-8: Get reminder notes
    @GetMapping("/getReminderNotesList")
    public ResponseEntity<List<NoteResponse>> getReminderNotesList(Authentication authentication) {
        return ResponseEntity.ok(noteService.getReminderNotes(authentication.getName()));
    }

    // UC-11: Import notes from Excel with read/write/skip counts
    @PostMapping(value = "/importExcel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<NoteImportResult> importExcel(@RequestParam("file") MultipartFile file,
                                                        Authentication authentication) throws IOException {
        return ResponseEntity.ok(noteExcelBatchService.importNotes(file, authentication.getName()));
    }

    // UC-11: Export logged-in user's active notes to Excel
    @GetMapping("/exportExcel")
    public ResponseEntity<ByteArrayResource> exportExcel(Authentication authentication) throws IOException {
        byte[] excelFile = noteExcelBatchService.exportNotes(authentication.getName());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=notes.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new ByteArrayResource(excelFile));
    }
}
