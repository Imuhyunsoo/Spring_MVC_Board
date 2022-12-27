package edu.global.ex.mapper;

import edu.global.ex.vo.DeptVO;
import edu.global.ex.vo.EmpDeptVO;
import edu.global.ex.vo.EmpVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpMapperTest {

    @Autowired
    private EmpMapper empMapper;

    @Test
    void testGetEmpDeptList() {

        List<EmpDeptVO> vos = empMapper.getEmpDeptList();

        for(EmpDeptVO vo : vos) {
            System.out.println(vo);
        }
    }

    @Test
    void testGetDeptEmpList() {

        List<DeptVO> vos = empMapper.getDeptEmpList();

        for(DeptVO vo : vos) {
            System.out.println(vo);
            for(EmpVO emp : vo.getEmpList()) {
                System.out.println(emp);
            }
        }
    }
}