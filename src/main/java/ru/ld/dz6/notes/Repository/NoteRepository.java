package ru.ld.dz6.notes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ld.dz6.notes.Model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
