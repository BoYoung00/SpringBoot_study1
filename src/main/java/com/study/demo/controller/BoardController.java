package com.study.demo.controller;

import com.study.demo.entity.Board;
import com.study.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm() {
        return "boardWrite";
    }

    @PostMapping("/board/writePro")
    public String boardWritPro(Board board) {
        boardService.write(board);

//        System.out.println("제목 : " + board.getTitle());
//        System.out.println("내용 : " + board.getContent());
        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardService.boardList());
        return "boardlist";
    }

    @GetMapping("/board/view") // view?id=1
    public String boardView(Model model, int id) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(int id) {
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") int id, Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") int id, Board board) {
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }

//    @GetMapping("/")
//    @ResponseBody
//    public String main() {
//        return "Hello world";
//    }
}
