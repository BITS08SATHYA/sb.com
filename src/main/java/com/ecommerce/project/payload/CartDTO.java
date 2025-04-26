package com.ecommerce.project.payload;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long cartId;
    private Double totalPrice = 0.0;
    private List<ProductDTO> products = new ArrayList<>();

}
