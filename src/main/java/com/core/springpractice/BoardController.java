package com.core.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

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
