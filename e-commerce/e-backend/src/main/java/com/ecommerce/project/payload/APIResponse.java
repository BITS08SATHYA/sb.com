package com.ecommerce.project.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter@ToString
public class APIResponse {
    private String message;
    private boolean status;
}
