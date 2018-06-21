package com.example.boot6.persistence;

import com.example.boot6.domain.WebReply;
import org.springframework.data.repository.CrudRepository;

public interface WebReplyRepository extends CrudRepository<WebReply,Long> {
}
