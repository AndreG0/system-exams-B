package com.system.exams.controller;


import com.system.exams.entity.Exam;
import com.system.exams.entity.Question;
import com.system.exams.service.ExamService;
import com.system.exams.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @GetMapping("/exam/all/{examId}")
    public ResponseEntity<?>listQuestionExamAsAdmin(@PathVariable ("examId")int examId){
        Exam exam = new Exam();
        exam.setExamId(examId);
        Set<Question> questions = questionService.getQuestionsFromTheExam(exam);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/review-exam")
    public ResponseEntity<?> reviewExam(@RequestBody List<Question> questions){
        double maximumPoints = 0;
        Integer correctAnswers = 0;
        Integer attempts = 0;

        for(Question q : questions){
            Question question = this.questionService.listQuestion(q.getQuestionId());
            if (question.getAnswer().equals(q.getAnswerChosen())){
                correctAnswers ++;
                double points = Double.parseDouble(questions.get(0).getExam().getMaximumPoints())/questions.size();
                maximumPoints += points;
            }

            if (q.getAnswerChosen() != null){
                attempts ++;
            }
        }

        Map<String, Object> answers = new HashMap<>();
        answers.put("maximumPoints", maximumPoints);
        answers.put("correctAnswers", correctAnswers);
        answers.put("attempts", attempts);
        return ResponseEntity.ok(answers);

    }

}
