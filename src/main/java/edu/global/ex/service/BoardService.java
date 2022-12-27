package edu.global.ex.service;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

import java.util.List;

public interface BoardService {

    public List<BoardVO> getList();
    public void register(BoardVO boardVO);

    BoardVO read(int bid);  // 글보기 메소드
    int remove(BoardVO boardVO);

    void registerReply(BoardVO boardVO);
    int getTotal();     // paging
    List<BoardVO> getList(Criteria criteria);   // 리스트 메소드

    int modify(BoardVO boardVO);
}
