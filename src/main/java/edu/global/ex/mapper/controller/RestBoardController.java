package edu.global.ex.mapper.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class RestBoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public List<BoardVO> list(Model model){
        log.info("list() ..");

        return boardService.getList();
    }

    // restful 이란 url 을 파라미터화 하는것
    // 기존 : http://localhost:8282/borads/delete?bid=905
    // restful : http://localhost:8282/borads/905
    @DeleteMapping("/{bid}")
    public int delete(BoardVO boardVO) {

        log.info("delete() ..");

        int rn = boardService.remove(boardVO);

        return rn;
    }

    /* @PutMapping("/{bid}")
    // @RequestBody : JSON 으로 받은 파일형태를 자동으로 BoardVO 형태로 넣어서 사용할 수 있다.
     public int modify(@RequestBody BoardVO boardVO) {

        log.info("modify() ..");
        log.info("modify() .." + boardVO);

        int rn = boardService.modify(boardVO);

        return rn;
    } */

    @PutMapping("/{bid}")
    public ResponseEntity<String> rest_update(@RequestBody BoardVO boardVO){

        log.info("rest_update() ..");

        ResponseEntity<String> entity = null;

        System.out.println(boardVO);

        try {
            int rn = boardService.modify(boardVO);
            log.info("Update 넘어온 숫자:::" + rn );

            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @PostMapping("/rest_write")
    public ResponseEntity<String> write(@RequestBody BoardVO boardVO) {

        log.info("rest_write() ..");

        ResponseEntity<String> entity = null;

        System.out.println(boardVO);

        try {

            boardService.register(boardVO);

            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
