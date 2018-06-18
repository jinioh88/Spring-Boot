package com.example.boot2;

import com.example.boot2.domain.Board;
import com.example.boot2.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        Board board = new Board();
        board.setTitle("게시물 제목");
        board.setContent("게시물 내용..");
        board.setWriter("홍길동");

        boardRepository.save(board);
    }
}
