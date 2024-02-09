package ru.ld.dz6.notes.Controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.ld.dz6.notes.Model.Note;
import ru.ld.dz6.notes.Service.NoteService;

import java.util.List;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NoteService service;

    /**
     * Создание заметки
     * @param note форма заметки (передаваемые параметры: title, description)
     * @return вовращает сообщение о том, что заметка создана или ошибочный запрос в случе, если переданы неверные параметры
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        try {
            return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Вывод всех заметок
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes() {
        return new ResponseEntity<>(service.findAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
        } else return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        try {
            if (service.updateNote(note, id) != null) {
                return ResponseEntity.ok().build();
            } else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteNote(id);
            return ResponseEntity.ok().build();
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
