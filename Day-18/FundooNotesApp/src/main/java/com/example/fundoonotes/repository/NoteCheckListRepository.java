package com.example.fundoonotes.repository;

import com.example.fundoonotes.entity.NoteCheckList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteCheckListRepository extends JpaRepository<NoteCheckList, Integer> {
    List<NoteCheckList> findByNote_NoteIdAndNote_User_EmailAndDeletedFalse(int noteId, String email);

    Optional<NoteCheckList> findByIdAndNote_NoteIdAndNote_User_EmailAndDeletedFalse(
            int id, int noteId, String email);
}
