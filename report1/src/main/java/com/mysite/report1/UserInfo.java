package com.mysite.report1;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserInfo implements Serializable{

    private static final long serialVersionUID = -805775324677826249L;
    private int id;
    private String email;
    private String name;
    private String ip;
    private String homepage;
    
    
    
    
}
