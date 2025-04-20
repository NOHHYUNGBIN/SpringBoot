package com.core.springpractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void getListTest() {
        List<Board> list = boardService.getList();
        System.out.println("list = " + list);
        assertEquals(10, list.size());
    }
    @Test
    public void writeAndReadTest() {
        User user = new User();
        user.setId("userB");
        userRepository.save(user);

        Board board = new Board();
        board.setBno(11L);
        board.setTitle("test title");
        board.setContent("test content");
        board.setUser(user);
        board.setViewCount(0L);
        board.setInDate(new Date());
        board.setUpDate(new Date());
        boardService.write(board);

        Board read = boardService.read(11L);
        System.out.println("read = " + read);
        assertTrue(read != null);
    }

    @Test
    public void modifyTest() {
        Board board = boardService.read(1L);
        board.setTitle("modify title");
        board.setContent("modify content");
        boardService.modify(board);

        Board board2 = boardService.read(1L);
        assertEquals("modify title", board2.getTitle());
        assertEquals("modify content", board2.getContent());
    }
    @Test
    public void removeTest() {
        Long testBno = 5L;
        boardService.remove(testBno);
        assertNull(boardService.read(testBno));
    }

    @BeforeEach
    public void init() {
        for(Long i = 1L; i<=10; i++) {
            Board board = new Board();
            board.setBno(i);
            board.setTitle("title" + i);
            board.setContent("content" + i);

            User user = new User();
            user.setId("userA");
            userRepository.save(user);

            board.setUser(user);
            board.setViewCount(0L);
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardService.write(board);
        }
    }
}