package edu.global.ex.service;

import edu.global.ex.mapper.EmpMapper;
import edu.global.ex.page.Criteria;
import edu.global.ex.vo.DeptVO;
import edu.global.ex.vo.EmpDeptVO;
import edu.global.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int getTotal() {

        log.info("getTotal() ..");

        return empMapper.getTotalCount();
    }

    @Override
    public List<EmpVO> getList(Criteria criteria) {

        log.info("getList(Criteria criteria) ..");

        return empMapper.getListWithPaging(criteria);
    }

    public List<EmpVO> getList() {

        log.info("getList() ..");

        return empMapper.getList();
    }

    @Override
    public List<DeptVO> getDeptList() {

        log.info("getDeptList() ..");

        return empMapper.getDeptEmpList();
    }

    @Override
    public List<EmpDeptVO> getEmpDeptList() {

        log.info("getEmpDeptList() ..");

        return empMapper.getEmpDeptList();
    }



}
