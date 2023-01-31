package com.system.exams.repository;

import com.system.exams.entity.Exam;
import com.system.exams.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Set<Question> findByExam(Exam exam);
}
