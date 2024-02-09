package ru.ld.dz6.notes.Service;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.ld.dz6.notes.Model.Note;
import ru.ld.dz6.notes.Repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository repository;

    public Note createNote(Note note) {
        return repository.save(note);
    }

    public List<Note> findAllNotes(){
        return repository.findAll();
    }

    public Optional<Note> findById(Long id) {
        return repository.findById(id);
    }

    public Note updateNote(Note note, Long id) {
        if (findById(id).isPresent()) {
            note.setId(id);
            return repository.save(note);
        } else return null;
    }

    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
