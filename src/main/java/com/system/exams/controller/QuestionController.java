package com.system.exams.controller;


import com.system.exams.entity.Exam;
import com.system.exams.entity.Question;
import com.system.exams.service.ExamService;
import com.system.exams.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ExamService examService;


    @PostMapping("/create")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.createQuestion(question));
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.upDateQuestion(question));
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<?> listOfQuestionForExam(@PathVariable ("examId") int examId){
        Exam exam = examService.getExam(examId);
        Set<Question> questions = exam.getQuestions();

        List exams = new ArrayList(questions);
        if (exams.size() > Integer.parseInt(exam.getNumberQuestions())){
            exams = exams.subList(0, Integer.parseInt(exam.getNumberQuestions() + 1));
        }
        Collections.shuffle(exams);
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/questionId")
    public Question getById(@PathVariable("questionId") int questionId){
        return  questionService.getQuestion(questionId);
    }

    @DeleteMapping("/{questionId}")
    public void deleteQuestion (@PathVariable("questionId") int questionId){
        questionService.deleteQuestion(questionId );
    }

}
