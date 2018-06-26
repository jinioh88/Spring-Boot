package com.example.boot6.controller;

import com.example.boot6.domain.WebBoard;
import com.example.boot6.domain.WebReply;
import com.example.boot6.persistence.WebReplyRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies/*")
@Log
public class WebReplyController {

    @Autowired
    private WebReplyRepository replyRepository;

    @PostMapping("/{bno}")
    public ResponseEntity<List<WebReply>> addReply(@PathVariable("bno") Long bno, @RequestBody WebReply reply) {
        log.info("addReply...");
        log.info("BNO: " + bno);
        log.info("Reply : " + reply);

        WebBoard board = new WebBoard();
        board.setBno(bno);

        reply.setBoard(board);
        replyRepository.save(reply);

        return new ResponseEntity<>(getListByBoard(board), HttpStatus.CREATED);
    }

    private List<WebReply> getListByBoard(WebBoard board) throws RuntimeException {
        log.info("getListByBaord..." + board);
        return replyRepository.getRepliesOfBoard(board);
    }

    @Transactional
    @PutMapping("/{bno}")
    public ResponseEntity<List<WebReply>> modify(@PathVariable("bno") Long bno, @RequestBody WebReply reply) {
        log.info("modify reply: " + reply);

        replyRepository.findById(reply.getRno()).ifPresent(origin -> {
            origin.setReplyText(reply.getReplyText());
            replyRepository.save(origin);
        });

        WebBoard board = new WebBoard();
        board.setBno(bno);

        return new ResponseEntity<>(getListByBoard(board), HttpStatus.CREATED);
    }

    @GetMapping("/{bno}")
    public ResponseEntity<List<WebReply>> getReplies(@PathVariable("bno") Long bno) {
        log.info("get All Replies...");

        WebBoard board = new WebBoard();
        board.setBno(bno);
        return new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);
    }
}
