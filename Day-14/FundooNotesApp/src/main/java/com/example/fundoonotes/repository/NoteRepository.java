package com.example.fundoonotes.repository;

import com.example.fundoonotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByUser_EmailAndTrashedFalse(String email);

    Optional<Note> findByNoteIdAndUser_Email(int noteId, String email);
}
