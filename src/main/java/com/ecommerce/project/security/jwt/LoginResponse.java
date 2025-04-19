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

    private String jwtToken;
    private String username;
    private List<String> roles;

//    public LoginResponse(String jwtToken, String username, List<String> roles) {
//
//        this.username = username;
//        this.roles = roles;
//    }
}
