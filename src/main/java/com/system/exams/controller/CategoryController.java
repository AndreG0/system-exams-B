package com.system.exams.controller;


import com.system.exams.entity.Category;
import com.system.exams.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category saveCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(saveCategory);
    }

    @GetMapping("/{categoryId}")
    public Category getById(@PathVariable ("categoryId") int categoryId){
        return categoryService.getCategory(categoryId);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PutMapping("/update")
    public Category updateCategory (@RequestBody Category category){
        return categoryService.upDateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable ("categoryId") int categoryId){
        categoryService.deleteCategory(categoryId);

    }
}
