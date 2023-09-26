package com.hotlist.conroller;

import com.hotlist.entity.NoteEntity;
import com.hotlist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

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
