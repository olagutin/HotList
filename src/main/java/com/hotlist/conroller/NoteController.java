package com.hotlist.conroller;

import com.hotlist.entity.NoteEntity;
import com.hotlist.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity createNote(@RequestBody NoteEntity note,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(noteService.createNote(note, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @PutMapping
    public ResponseEntity completeNote(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(noteService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
