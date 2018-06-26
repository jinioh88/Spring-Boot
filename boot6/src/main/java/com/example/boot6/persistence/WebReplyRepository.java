package com.example.boot6.persistence;

import com.example.boot6.domain.WebBoard;
import com.example.boot6.domain.WebReply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WebReplyRepository extends CrudRepository<WebReply, Long> {
    @Query("select r from WebReply r where r.board = ?1 and r.rno > 0 order by r.rno asc")
    public List<WebReply> getRepliesOfBoard(WebBoard board);
}
