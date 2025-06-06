package com.ecommerce.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@ToString
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank
    @Size(min=5, message = "Category name must contain atleast 5 characters")
    private String categoryName;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;


}
