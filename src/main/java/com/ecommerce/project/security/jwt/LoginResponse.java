package com.ecommerce.project.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LoginResponse {

    private Long id;
    private String jwtToken;
    private String username;
    private List<String> roles;


    //    public LoginResponse(String jwtToken, String username, List<String> roles) {
//
//        this.username = username;
//        this.roles = roles;
//    }


    public LoginResponse(Long id, String username, List<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }
}
