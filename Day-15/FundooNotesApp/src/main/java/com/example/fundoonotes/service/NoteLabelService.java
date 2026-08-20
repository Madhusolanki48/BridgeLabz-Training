package com.example.fundoonotes.service;

import com.example.fundoonotes.dto.LabelRequest;
import com.example.fundoonotes.dto.LabelResponse;
import com.example.fundoonotes.entity.NoteLabel;
import com.example.fundoonotes.entity.User;
import com.example.fundoonotes.exception.InvalidCredentialsException;
import com.example.fundoonotes.exception.LabelAlreadyExistsException;
import com.example.fundoonotes.exception.LabelNotFoundException;
import com.example.fundoonotes.repository.NoteLabelRepository;
import com.example.fundoonotes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteLabelService {
    private final NoteLabelRepository noteLabelRepository;
    private final UserRepository userRepository;

    public NoteLabelService(NoteLabelRepository noteLabelRepository, UserRepository userRepository) {
        this.noteLabelRepository = noteLabelRepository;
        this.userRepository = userRepository;
    }

    // UC-1: Create label
    public LabelResponse createLabel(LabelRequest request, String email) {
        checkDuplicateLabel(request.getLabel(), email);

        NoteLabel label = new NoteLabel();
        label.setLabel(request.getLabel());
        label.setUser(getUser(email));

        return mapToResponse(noteLabelRepository.save(label));
    }

    // UC-2: Get active labels
    public List<LabelResponse> getLabels(String email) {
        return noteLabelRepository.findByUser_EmailAndDeletedFalse(email)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // UC-3: Update label
    public LabelResponse updateLabel(int id, LabelRequest request, String email) {
        NoteLabel label = getLabel(id, email);
        if (!label.getLabel().equalsIgnoreCase(request.getLabel())) {
            checkDuplicateLabel(request.getLabel(), email);
        }
        label.setLabel(request.getLabel());
        return mapToResponse(noteLabelRepository.save(label));
    }

    // UC-4: Soft delete label
    public String deleteLabel(int id, String email) {
        NoteLabel label = getLabel(id, email);
        label.setDeleted(true);
        noteLabelRepository.save(label);
        return "Label deleted successfully";
    }

    private void checkDuplicateLabel(String label, String email) {
        if (noteLabelRepository.findByLabelIgnoreCaseAndUser_EmailAndDeletedFalse(label, email).isPresent()) {
            throw new LabelAlreadyExistsException("Label already exists!");
        }
    }

    private User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredentialsException("User not found!"));
    }

    private NoteLabel getLabel(int id, String email) {
        return noteLabelRepository.findByIdAndUser_EmailAndDeletedFalse(id, email)
                .orElseThrow(() -> new LabelNotFoundException("Label not found!"));
    }

    private LabelResponse mapToResponse(NoteLabel label) {
        return new LabelResponse(label.getId(), label.getLabel());
    }
}
