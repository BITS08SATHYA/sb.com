package com.ecommerce.project.payload;


import lombok.*;

@NoArgsConstructor
@Getter@Setter
@ToString
@AllArgsConstructor
public class CategoryDTO {

    private Long categoryId;
    private String categoryName;
}
