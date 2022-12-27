package edu.global.ex.service;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.DeptVO;
import edu.global.ex.vo.EmpDeptVO;
import edu.global.ex.vo.EmpVO;

import java.util.List;

public interface EmpService {

    int getTotal();
    List<EmpVO> getList(Criteria criteria);

    List<EmpVO> getList();

    List<DeptVO> getDeptList();     // 조인 테이블
    List<EmpDeptVO> getEmpDeptList();       // 조인 테이블
}
