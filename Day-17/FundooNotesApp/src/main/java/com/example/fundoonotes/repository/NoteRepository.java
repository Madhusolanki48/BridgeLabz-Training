package com.example.fundoonotes.repository;

import com.example.fundoonotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer>, JpaSpecificationExecutor<Note> {
    List<Note> findByUser_EmailAndTrashedFalse(String email);

    List<Note> findByUser_EmailAndArchivedFalseAndTrashedFalse(String email);

    List<Note> findByUser_EmailAndArchivedTrueAndTrashedFalse(String email);

    List<Note> findByUser_EmailAndTrashedTrue(String email);

    List<Note> findByUser_EmailAndLabels_LabelAndLabels_DeletedFalseAndTrashedFalse(String email, String label);

    Optional<Note> findByNoteIdAndUser_Email(int noteId, String email);
}
