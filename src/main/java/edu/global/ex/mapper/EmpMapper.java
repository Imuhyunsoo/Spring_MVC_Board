package edu.global.ex.mapper;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.DeptVO;
import edu.global.ex.vo.EmpDeptVO;
import edu.global.ex.vo.EmpVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


// 1 버전, 2 버전, 3 버전
@Mapper
public interface EmpMapper {

    List<EmpVO> getList();

    @Select("SELECT * FROM EMP E, DEPT D WHERE D.DEPTNO = E.DEPTNO")
    // 마이바티스 3 버전 부터 적용이 된다.
    List<EmpDeptVO> getEmpDeptList();

    List<DeptVO> getDeptEmpList();

    int getTotalCount();
    List<EmpVO> getListWithPaging(Criteria criteria);
}
