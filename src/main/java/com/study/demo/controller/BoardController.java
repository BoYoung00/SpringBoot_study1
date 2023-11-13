package com.study.demo.controller;

import com.study.demo.entity.Board;
import com.study.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "";
    }

//    @GetMapping("/")
//    @ResponseBody
//    public String main() {
//        return "Hello world";
//    }
}
