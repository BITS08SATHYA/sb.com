package com.ecommerce.project.payload;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    private Long productId;
    private Integer quantity;


}
