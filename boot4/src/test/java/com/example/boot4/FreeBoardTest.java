package com.example.boot4;

import com.example.boot4.domain.FreeBoard;
import com.example.boot4.domain.FreeBoardReply;
import com.example.boot4.persistence.FreeBoardReplyRepository;
import com.example.boot4.persistence.FreeBoardRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class FreeBoardTest {
    @Autowired
    FreeBoardRepository boardRepository;

    @Autowired
    FreeBoardReplyRepository replyRepository;

    @Test
    public void insertDummy() {
        IntStream.range(1, 200).forEach(i -> {
            FreeBoard board = new FreeBoard();
            board.setTitle("Free board ..." + i);
            board.setContent("Free Content.." + i);
            board.setWriter("user" + 1 % 10);

            boardRepository.save(board);
        });
    }

    @Transactional
    @Test
    public void insertReply2() {
        Optional<FreeBoard> result = boardRepository.findById(199L);

        result.ifPresent(board -> {
            List<FreeBoardReply> replies = board.getReplies();
            FreeBoardReply reply = new FreeBoardReply();
            reply.setReply("reply....");
            reply.setReplyer("replyer001");
            reply.setBoard(board);

            replies.add(reply);
            board.setReplies((replies));

            boardRepository.save(board);
        });
    }

    @Test
    public void insertReply1() {
        FreeBoard board = new FreeBoard();
        board.setBno(199L);

        FreeBoardReply reply = new FreeBoardReply();
        reply.setReplyer("reply1...");
        reply.setReplyer("replyer002");
        reply.setBoard(board);

        replyRepository.save(reply);
    }

    @Test
    public void testList1() {
        Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
        boardRepository.findByBnoGreaterThan(0L, page).forEach(board -> {
            log.info(board.getBno() + " : " + board.getTitle());
        });
    }

    @Transactional
    @Test
    public void testList2() {
        Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
        boardRepository.findByBnoGreaterThan(0L, page).forEach(board -> {
            log.info(board.getBno() + " : " + board.getTitle() + " : " + board.getReplies().size());
        });
    }

    @Test
    public void testList3() {
        Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");

        boardRepository.getPage(page).forEach(arr -> log.info(Arrays.toString(arr)));
    }
}
