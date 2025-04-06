package com.ecommerce.project.payload;

import com.ecommerce.project.model.Product;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class ProductResponse {

    private List<ProductDTO> content;

}
