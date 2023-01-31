package com.system.exams.service.Impl;

import com.system.exams.entity.Exam;
import com.system.exams.entity.Question;
import com.system.exams.repository.QuestionRepository;
import com.system.exams.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question upDateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return (Set<Question>) questionRepository.findAll();
    }

    @Override
    public Question getQuestion(int questionId) {
        return questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsFromTheExam(Exam exam) {
        return questionRepository.findByExam(exam);
    }

    @Override
    public void deleteQuestion(int questionId) {
       Question question = new Question();
       question.setQuestionId(questionId);
       questionRepository.delete(question);
    }

    @Override
    public Question listQuestion(int questionId) {
        return null;
    }
}
