package com.example.boot4.persistence;

import com.example.boot4.domain.FreeBoard;
import com.example.boot4.domain.FreeBoardReply;
import org.springframework.data.repository.CrudRepository;

public interface FreeBoardReplyRepository extends CrudRepository<FreeBoardReply, Long> {
}
