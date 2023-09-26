package com.hotlist.repository;

import com.hotlist.entity.NoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends CrudRepository<NoteEntity, Long> {
}
