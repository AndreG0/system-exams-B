package com.system.exams.service;

import com.system.exams.entity.Exam;
import com.system.exams.entity.Question;

import java.util.Set;

public interface QuestionService {

    Question createQuestion(Question question);

    Question upDateQuestion(Question question);

    Set<Question> getQuestions();

    Question getQuestion(int questionId);

    Set<Question>getQuestionsFromTheExam(Exam exam);

    void deleteQuestion(int questionId);

    Question listQuestion(int questionId);


}
