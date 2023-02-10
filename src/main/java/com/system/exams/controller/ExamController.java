package com.system.exams.controller;
import com.system.exams.entity.Category;
import com.system.exams.entity.Exam;
import com.system.exams.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
@CrossOrigin("*")
public class ExamController {


    @Autowired
    private ExamService examService;


    @PostMapping("/create")
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.createExam(exam));
    }

    @PutMapping("/update")
    public ResponseEntity<Exam> updateExam (@RequestBody Exam exam){
        return ResponseEntity.ok(examService.upDateExam(exam));
    }
    @GetMapping("/list")
    public ResponseEntity<?> listExams(){
        return ResponseEntity.ok(examService.getExams());
    }

    @GetMapping("/{examId}")
    public Exam getById(@PathVariable ("examId") int examId){
        return examService.getExam(examId);
    }

    @DeleteMapping("/{examId}")
    public void deleteExam(@PathVariable ("examId") int examId){
        examService.deleteExam(examId);
    }

    @GetMapping("/category/{categoryId}")
   public List<Exam> listExamsByCategory(@PathVariable ("categoryId") int categoryId){
        Category category = new Category();
        category.setCategoryId(categoryId);
        return examService.listExamsByCategory(category);
    }
    @GetMapping("/active")
    public List<Exam> listActiveExam(){
        return examService.listExamActive();
    }


    @GetMapping("/category/active/{categoryId}")
    public List<Exam> listExamActiveByCategory(@PathVariable ("categoryId") int categoryId){
        Category category = new Category();
        category.setCategoryId(categoryId);
        return examService.listExamActiveByCategory(category);
    }
}
