package edu.global.ex.mapper;

import edu.global.ex.vo.EmpVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpList {

    @Autowired  // 주입
    private EmpMapper empMapper;

    @Test
    void testList() {
        System.out.println(empMapper);

        List<EmpVO> empVOList = empMapper.getList();

        for(EmpVO emp : empVOList) {
            System.out.println(emp);
        }
    }
}