package com.system.exams.service;

import com.system.exams.entity.Category;

import java.util.Set;

public interface CategoryService {

    Category createCategory(Category category);

    Category upDateCategory(Category category);

    Set<Category> getCategories();

    Category getCategory(int categoryId);

    void deleteCategory(int categoryId);
}
