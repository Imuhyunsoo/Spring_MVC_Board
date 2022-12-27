package edu.global.ex.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardVOTest {

    @Test
    void testBoardVO() {    // 단위 테스트
        BoardVO vo = new BoardVO();

        vo.setBname("홍길동");

        assertEquals(vo.getBname(), "홍길동");

        System.out.println(vo);
    }
}