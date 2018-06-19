package com.example.boot4.persistence;

import com.example.boot4.domain.PDSBoard;
import org.springframework.data.repository.CrudRepository;

public interface PDSBaordRepository extends CrudRepository<PDSBoard,Long> {
}
