package edu.global.ex.vo;


import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpVO {

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private String sal;
    private String comm;
    private int deptno;

}
