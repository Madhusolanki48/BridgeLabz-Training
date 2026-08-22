package com.example.fundoonotes.controller;

import com.example.fundoonotes.dto.LabelRequest;
import com.example.fundoonotes.dto.LabelResponse;
import com.example.fundoonotes.service.NoteLabelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noteLabels")
public class NoteLabelController {
    private final NoteLabelService noteLabelService;

    public NoteLabelController(NoteLabelService noteLabelService) {
        this.noteLabelService = noteLabelService;
    }

    // UC-6: Create label
    @PostMapping
    public ResponseEntity<LabelResponse> createLabel(@Valid @RequestBody LabelRequest request,
                                                     Authentication authentication) {
        LabelResponse response = noteLabelService.createLabel(request, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // UC-6: Get active labels
    @GetMapping("/getNoteLabelList")
    public ResponseEntity<List<LabelResponse>> getNoteLabelList(Authentication authentication) {
        return ResponseEntity.ok(noteLabelService.getLabels(authentication.getName()));
    }

    // UC-6: Update label
    @PatchMapping("/{id}")
    public ResponseEntity<LabelResponse> updateLabel(@PathVariable int id,
                                                     @Valid @RequestBody LabelRequest request,
                                                     Authentication authentication) {
        return ResponseEntity.ok(noteLabelService.updateLabel(id, request, authentication.getName()));
    }

    // UC-6: Soft delete label
    @DeleteMapping("/{id}/deleteNoteLabel")
    public ResponseEntity<String> deleteNoteLabel(@PathVariable int id,
                                                 Authentication authentication) {
        return ResponseEntity.ok(noteLabelService.deleteLabel(id, authentication.getName()));
    }
}
