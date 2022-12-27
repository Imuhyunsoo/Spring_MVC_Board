package edu.global.ex.vo;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpDeptVO {

    // Emp Table
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Timestamp hiredate;
    private String sal;
    private String comm;
    private int deptno;

    // Dept Table
    private String dname;
    private String loc;
}
