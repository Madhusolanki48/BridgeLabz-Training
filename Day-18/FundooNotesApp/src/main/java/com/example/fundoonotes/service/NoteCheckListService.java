package com.example.fundoonotes.service;

import com.example.fundoonotes.dto.CheckListRequest;
import com.example.fundoonotes.dto.CheckListResponse;
import com.example.fundoonotes.entity.Note;
import com.example.fundoonotes.entity.NoteCheckList;
import com.example.fundoonotes.exception.CheckListNotFoundException;
import com.example.fundoonotes.exception.NoteNotFoundException;
import com.example.fundoonotes.repository.NoteCheckListRepository;
import com.example.fundoonotes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteCheckListService {
    private final NoteCheckListRepository checkListRepository;
    private final NoteRepository noteRepository;

    public NoteCheckListService(NoteCheckListRepository checkListRepository, NoteRepository noteRepository) {
        this.checkListRepository = checkListRepository;
        this.noteRepository = noteRepository;
    }

    // UC-12: Add checklist item under an owned note
    public CheckListResponse addItem(int noteId, CheckListRequest request, String email) {
        Note note = getOwnedNote(noteId, email);

        NoteCheckList item = new NoteCheckList();
        item.setNote(note);
        updateItem(item, request);
        return mapToResponse(checkListRepository.save(item));
    }

    // UC-12: Get active checklist items for an owned note
    public List<CheckListResponse> getItems(int noteId, String email) {
        getOwnedNote(noteId, email);
        return checkListRepository.findByNote_NoteIdAndNote_User_EmailAndDeletedFalse(noteId, email)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // UC-12: Update one checklist item
    public CheckListResponse updateItem(int noteId, int itemId, CheckListRequest request, String email) {
        NoteCheckList item = getOwnedItem(noteId, itemId, email);
        updateItem(item, request);
        return mapToResponse(checkListRepository.save(item));
    }

    // UC-12: Soft delete one checklist item
    public String deleteItem(int noteId, int itemId, String email) {
        NoteCheckList item = getOwnedItem(noteId, itemId, email);
        item.setDeleted(true);
        checkListRepository.save(item);
        return "Checklist item deleted successfully";
    }

    private Note getOwnedNote(int noteId, String email) {
        return noteRepository.findByNoteIdAndUser_Email(noteId, email)
                .orElseThrow(() -> new NoteNotFoundException("Note not found!"));
    }

    private NoteCheckList getOwnedItem(int noteId, int itemId, String email) {
        return checkListRepository.findByIdAndNote_NoteIdAndNote_User_EmailAndDeletedFalse(itemId, noteId, email)
                .orElseThrow(() -> new CheckListNotFoundException("Checklist item not found!"));
    }

    private void updateItem(NoteCheckList item, CheckListRequest request) {
        item.setItemName(request.getItemName());
        item.setStatus(request.getStatus());
    }

    private CheckListResponse mapToResponse(NoteCheckList item) {
        return new CheckListResponse(item.getId(), item.getItemName(), item.getStatus(), item.isDeleted());
    }
}
