package edu.global.ex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = {"edu.global.ex.Mapper"})  // Mapper 읽기
@SpringBootApplication  // 두개 의 어노테이션 @ComponentScan 과 @EnableAutoConfiguration 이 핵심
public class MvcBoardApplication {

    public static void main(String[] args) {

        SpringApplication.run(MvcBoardApplication.class, args);
    }
}
