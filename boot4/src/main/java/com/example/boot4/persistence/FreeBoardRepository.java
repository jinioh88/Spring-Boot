package com.example.boot4.persistence;

import com.example.boot4.domain.FreeBoard;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FreeBoardRepository extends CrudRepository<FreeBoard,Long> {
    public List<FreeBoard> findByBnoGreaterThan(Long bno, Pageable page);
}
