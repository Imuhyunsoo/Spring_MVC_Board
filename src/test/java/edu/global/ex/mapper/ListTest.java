package edu.global.ex.mapper;

import edu.global.ex.vo.BoardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ListTest {

    @Autowired  // 주입
    private BoardMapper boardMapper;

    @Test
    void testList() {
        System.out.println(boardMapper);

        List<BoardVO> boards = boardMapper.getList();

        for(BoardVO board : boards) {
            System.out.println(board);
        }
    }
}