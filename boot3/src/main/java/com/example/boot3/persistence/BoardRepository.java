package com.example.boot3.persistence;

import com.example.boot3.domain.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    public List<Board> findBoardByTitle(String title);

    public Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
}
