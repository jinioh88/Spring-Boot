package com.example.boot6.controller;

import com.example.boot6.domain.WebReply;
import com.example.boot6.persistence.WebReplyRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replies/*")
@Log
public class WebReplyController {

    @Autowired
    private WebReplyRepository replyRepository;

    @PostMapping("/{bno}")
    public ResponseEntity<Void> addReply(@PathVariable("bno")Long bno, @RequestBody WebReply reply){
        log.info("addReply...");
        log.info("BNO: "+bno);
        log.info("Reply : "+reply);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
