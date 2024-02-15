package com.hotlist.service;

import com.hotlist.entity.NoteEntity;
import com.hotlist.entity.UserEntity;
import com.hotlist.model.Note;
import com.hotlist.repository.NoteRepo;
import com.hotlist.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NoteRepo noteRepo;
    private final UserRepo userRepo;
    public NoteService(NoteRepo noteRepo, UserRepo userRepo) {
        this.noteRepo = noteRepo;
        this.userRepo = userRepo;
    }

    public Note createNote(NoteEntity note, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        note.setUser(user);
        return Note.toModel(noteRepo.save(note));
    }

    public Note complete(Long id) {
        NoteEntity note = noteRepo.findById(id).get();
        note.setCompleted(!note.getCompleted());
        return Note.toModel(noteRepo.save(note));
    }
}
