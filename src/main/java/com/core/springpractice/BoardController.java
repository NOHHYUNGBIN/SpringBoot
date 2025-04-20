package com.core.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/write")
    public String showWriteForm(Model model) {
        Board board = new Board();
        User user = new User();

        user.setId("userA");
        System.out.println("user = " + user);
        board.setUser(user.getId());

        model.addAttribute("board", board);
        return "/board/write";
    }

    @PostMapping("/write")
    public String write(Board board) {
        board.setViewCnt(0L);
        board.setInDate(new Date());
        board.setUpDate(new Date());

        List<Board> list = boardService.getList();
        Long bno = list.stream().mapToLong(Board::getBno).max().orElse(0L) + 1L;
        board.setBno(bno);
        boardService.write(board);
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(Long bno) {
        boardService.remove(bno);
        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public String read(Long bno, Model model) {
        Board board = boardService.read(bno);
        model.addAttribute("board", board);
        return "/board/read";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<Board> list = boardService.getList();
        System.out.println("list = " + list);
        model.addAttribute( "list",list);
        return "/board/list";
    }
}
