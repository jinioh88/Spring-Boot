package com.example.boot2.persistence;

import com.example.boot2.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board,Long> {

}
