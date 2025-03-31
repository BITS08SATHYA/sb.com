package com.ecommerce.project.service.impl;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.repository.CategoryRepository;
import com.ecommerce.project.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private Long nextId = 1L;
//    private List<Category> categories = new ArrayList<>();

    @Autowired
    private CategoryRepository repository;

//    public CategoryServiceImpl(CategoryRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public List<Category> getAllCategories() {

        List<Category> categories = repository.findAll();

        if(categories.isEmpty()){
            throw new APIException("No categories created till Now! ");
        }

        return categories;
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++);
        Category savedCategory = repository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists");
        }
        repository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category  = repository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId" , categoryId));

//        List<Category> categories = repository.findAll();
//
//        Category category = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));
//        if(category == null) {
//            return "Category not found";
//        }
        repository.delete(category);
        return "Category with CategoryId: " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

//        Optional<Category> savedCategoryOptional = repository.findById(categoryId);

        Category savedCategory = repository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId" , categoryId));

        category.setCategoryId(categoryId);
        savedCategory = repository.save(category);

//        Optional<Category> optionalCategory = categories.stream()
//                .filter(c -> c.getCategoryId().equals(categoryId))
//                .findFirst();
//        if(optionalCategory.isPresent()) {
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            return repository.save(existingCategory);
//        }else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found");
//        }
        return savedCategory;
    }
}
