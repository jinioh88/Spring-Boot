package com.example.boot2;

import com.example.boot2.domain.Board;
import com.example.boot2.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        Board board = new Board();
        board.setTitle("게시물 제목1");
        board.setContent("게시물 내용..");
        board.setWriter("홍길동1");

        boardRepository.save(board);
    }

    @Test
    public void testRead() {
        boardRepository.findById(1L).ifPresent((board)->{
            System.out.println(board);
        });
    }

//    @Test
//    public void testUpdate() {
//        System.out.println("Read First!");
//        Optional<Board> board = boardRepository.findById(1L);
//        board.ifPresent(board1 -> {board1.setTitle("수정된 제목입니다.");});
//
//        boardRepository.save(board.get());
//    }

    @Test
    public void testDelete(){
        boardRepository.deleteById(1L);
    }
}
