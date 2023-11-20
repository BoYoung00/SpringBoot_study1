package com.study.demo.service;

import com.study.demo.entity.Board;
import com.study.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 글 작성 처리
    public void write(Board board) {
        boardRepository.save(board); // DB에 값 넣기
    }

    // 게시글 리스트
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    // 특정 게시글 불러오기 (뷰)
    public Board boardView(int id) {
        return boardRepository.findById(id).get();
    }

    // 게시글 삭제
    public void boardDelete(int id) {
        boardRepository.deleteById(id);
    }
}
