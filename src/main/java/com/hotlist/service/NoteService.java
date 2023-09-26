package com.hotlist.service;

import com.hotlist.entity.NoteEntity;
import com.hotlist.entity.UserEntity;
import com.hotlist.model.Note;
import com.hotlist.repository.NoteRepo;
import com.hotlist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;
    @Autowired
    private UserRepo userRepo;

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
