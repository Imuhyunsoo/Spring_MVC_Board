package edu.global.ex.vo;

import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardVO {

    private int bid;
    private String bname;
    private String btitle;
    private String bcontent;
    private Timestamp bdate;
    private int bhit;
    private int bgroup;
    private int bstep;
    private int bindent;

}
