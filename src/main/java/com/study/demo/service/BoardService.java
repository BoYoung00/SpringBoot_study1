package com.study.demo.service;

import com.study.demo.entity.Board;
import com.study.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board); // DB에 값 넣기
    }
}
