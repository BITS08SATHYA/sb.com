package com.ecommerce.project.service.impl;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repository.CategoryRepository;
import com.ecommerce.project.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

//    private Long nextId = 1L;
//    private List<Category> categories = new ArrayList<>();

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private ModelMapper modelMapper;

//    public CategoryServiceImpl(CategoryRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize,String sortBy, String order) {

        Sort sortByAndOrder = order.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);

        Page<Category> categoryPage = repository.findAll(pageDetails);

        List<Category> categories = categoryPage.getContent();

        if(categories.isEmpty()){
            throw new APIException("No categories created till Now! ");
        }

        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setLastPage(categoryResponse.isLastPage());

        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Category category = modelMapper.map(categoryDTO, Category.class);

        Category categoryFromDB = repository.findByCategoryName(category.getCategoryName());
        if (categoryFromDB != null) {
            throw new APIException("Category with the name " + category.getCategoryName() + " already exists");
        }
        Category savedCategory = repository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {

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
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {

//        Optional<Category> savedCategoryOptional = repository.findById(categoryId);

        Category savedCategory = repository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId" , categoryId));

        Category category = modelMapper.map(categoryDTO, Category.class);
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
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }
}
