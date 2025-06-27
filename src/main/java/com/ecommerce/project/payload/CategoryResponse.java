package com.ecommerce.project.payload;

import com.ecommerce.project.model.Category;
import lombok.*;

import java.util.List;

@Getter@Setter@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private List<CategoryDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;
}
