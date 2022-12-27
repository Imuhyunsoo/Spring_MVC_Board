package edu.global.ex.vo;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeptVO {

    private String deptno;     // 부서 번호
    private String dname;   // 부서 이름
    private String loc;     // 지역

    // 1 대 다 처리
    List<EmpVO> empList;
}
