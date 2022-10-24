package com.penpal.project.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateForm {

    @Size(min = 3, max = 30)
    @NotEmpty(message = "아이디는 필수항목입니다.")
    private String userId;
    
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String userPw;
    
    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String userPw2;
    
    @Size(min = 3, max = 60)
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;
    
    @Size(min = 3, max = 150)
    @Email
    @NotEmpty(message = "이메일은 필수항목입니다.")
    private String email;
    
}