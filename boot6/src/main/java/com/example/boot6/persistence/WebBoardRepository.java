package com.example.boot6.persistence;

import com.example.boot6.domain.QWebBoard;
import com.example.boot6.domain.WebBoard;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface WebBoardRepository extends CrudRepository<WebBoard, Long>, QuerydslPredicateExecutor<WebBoard> {
    public default BooleanBuilder makePredicate(String type, String keyword) {
        BooleanBuilder builder = new BooleanBuilder();
        QWebBoard board = QWebBoard.webBoard;

        builder.and(board.bno.gt(0));
        if (type == null)
            return builder;
        switch (type) {
            case "t":
                builder.and(board.title.like("%" + keyword + "%"));
                break;
            case "c":
                builder.and(board.content.like("%" + keyword + "%"));
                break;
            case "w":
                builder.and(board.writer.like("%" + keyword + "%"));
                break;
        }
        return builder;
    }
}
