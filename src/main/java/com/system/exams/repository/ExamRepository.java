package com.system.exams.repository;

import com.system.exams.entity.Category;
import com.system.exams.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
    List<Exam> findByCategory(Category category);

    List<Exam> findByActive(Boolean status);

    List<Exam> findByCategoryAndActive(Category category, Boolean status);


}
