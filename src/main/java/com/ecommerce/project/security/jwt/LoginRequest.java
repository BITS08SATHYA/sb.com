package com.ecommerce.project.security.jwt;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
