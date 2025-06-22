package com.ecommerce.project.payload;

import lombok.*;

@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long orderItemId;
    private ProductDTO productDTO;
    private Integer quantity;
    private double discount;
    private double orderedProductPrice;

}
