package org.learn.bootreactproject.repository;

import org.learn.bootreactproject.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {

}
