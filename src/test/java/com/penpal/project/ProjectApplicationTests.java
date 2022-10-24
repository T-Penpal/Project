package com.penpal.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.penpal.project.board.BoardService;
import com.penpal.project.member.Member;

@SpringBootTest
class ProjectApplicationTests {

    @Autowired
    private BoardService boardService;
    
    @Test
    void testJpa() {
        Member member = new Member();
        for (int i = 1; i <= 300; i++) {
            String title = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            String category = "free";
            String location = "Asia";
            String country = "USA";
            this.boardService.create(title, content, null, null, null, member);
        }
    }
}
