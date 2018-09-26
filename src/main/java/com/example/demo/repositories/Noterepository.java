package com.example.demo.repositories;

import com.example.demo.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pramod-dilshan on 1/5/18.
 */

@Repository
public interface Noterepository extends JpaRepository<Note, Long> {
}

