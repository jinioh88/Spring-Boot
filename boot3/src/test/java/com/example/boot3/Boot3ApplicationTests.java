package com.example.boot3;

import com.example.boot3.domain.Board;
import com.example.boot3.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot3ApplicationTests {

    @Autowired
    private BoardRepository repository;

    @Test
    public void testInsert200(){
        for(int i=1;i<=200;i++){
            Board board = new Board();
            board.setTitle("제목"+i);
            board.setContent("내용"+i+" 채우기");
            board.setWriter("user0"+(i%10));
            repository.save(board);
        }
    }

    @Test
    public void testByTitle(){
        repository.findBoardByTitle("제목117").forEach(board->{
            System.out.println(board);
        });
    }

    @Test
    public void testBnoOrder(){
        Collection<Board> results = repository.findByBnoGreaterThanOrderByBnoDesc(90L);
        results.forEach(board-> System.out.println(board));
    }
}
