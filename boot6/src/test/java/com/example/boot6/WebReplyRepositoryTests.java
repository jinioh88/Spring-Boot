package com.example.boot6;

import com.example.boot6.domain.WebBoard;
import com.example.boot6.domain.WebReply;
import com.example.boot6.persistence.WebReplyRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class WebReplyRepositoryTests {
    @Autowired
    WebReplyRepository repo;

    @Test
    public void testInsert() {
        Long[] arr = {304L, 303L, 300L};
        Arrays.stream(arr).forEach(num -> {
            WebBoard board = new WebBoard();
            board.setBno(num);

            IntStream.range(0, 10).forEach(i -> {
                WebReply reply = new WebReply();
                reply.setReplyer("replyer" + i);
                reply.setReplyText("Reply..." + i);
                reply.setBoard(board);

                repo.save(reply);
            });
        });
    }
}
