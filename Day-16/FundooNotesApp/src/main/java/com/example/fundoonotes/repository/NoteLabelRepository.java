package com.example.fundoonotes.repository;

import com.example.fundoonotes.entity.NoteLabel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteLabelRepository extends JpaRepository<NoteLabel, Integer> {
    List<NoteLabel> findByUser_EmailAndDeletedFalse(String email);

    Optional<NoteLabel> findByIdAndUser_EmailAndDeletedFalse(int id, String email);

    Optional<NoteLabel> findByLabelIgnoreCaseAndUser_EmailAndDeletedFalse(String label, String email);
}
