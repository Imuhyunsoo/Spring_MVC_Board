package edu.global.ex.service;

import java.util.List;

import edu.global.ex.mapper.BoardMapper;
import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // 글 전체 목록
    @Override
    public List<BoardVO> getList() {

        log.info("getList() ..");     // log 시/분/초 로 표현해준다. Spring 내장

        return boardMapper.getList();
    }

    @Override
    public void register(BoardVO boardVO) {

        log.info("register() ..");
        boardMapper.insert(boardVO);
    }

    @Override
    public BoardVO read(int bid) {

        log.info("read() ..");

        return boardMapper.read(bid);
    }

    @Override
    public int remove(BoardVO board) {

        log.info("remove() ..");
        return boardMapper.delete(board);
    }

    @Transactional // 반드시 붙어야 하는 항목
    @Override
    public void registerReply(BoardVO boardVO) {

        log.info("registerReply() ..");

        boardMapper.updateShape(boardVO);   // 답글이 위치를 먼저 잡아준 후
        boardMapper.insertReply(boardVO);   // 답글을 등록한다.
    }

    @Override
    public int getTotal() {

        log.info("getTotal() ..");

        return boardMapper.getTotalCount();
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {

        log.info("getList(Criteria criteria) ..");

        return boardMapper.getListWithPaging(criteria);
    }

    @Override
    public int modify(BoardVO boardVO) {

        log.info("modify() ..");

        return boardMapper.update(boardVO);

    }
}
