package com.core.springpractice;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void init() {
        for(Long i = 1L; 1<=10; i++) {
            Board board = new Board();
            board.setBno(i);
            board.setTitle("title" + i);
            board.setContent("content" + i);

            User user = new User();
        }
    }
}