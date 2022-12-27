package edu.global.ex.mapper;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardVO> getList();
    BoardVO read(int bid);   // 파라미터는 URL 로 넘어오는 BID 값을 의미
    void insert(BoardVO boardVO);   // 글 작성
    void content(int bid);
    void delete(int bid);
    int delete(BoardVO boardVO);
    void updateShape(BoardVO boardVO);
    void insertReply(BoardVO boardVO);

    int getTotalCount();
    List<BoardVO> getListWithPaging(Criteria criteria);

    int update(BoardVO board);  // 글 수정
}
