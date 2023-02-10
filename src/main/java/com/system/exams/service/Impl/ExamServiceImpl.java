package com.system.exams.service.Impl;

import com.system.exams.entity.Category;
import com.system.exams.entity.Exam;
import com.system.exams.repository.ExamRepository;
import com.system.exams.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam upDateExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Set<Exam> getExams() {
        return new LinkedHashSet<>(examRepository.findAll());
    }

    @Override
    public Exam getExam(int examId) {
        return examRepository.findById(examId).get();
    }

    @Override
    public void deleteExam(int examId) {
        Exam exam = new Exam();
        exam.setExamId(examId);
        examRepository.delete(exam);
    }

    @Override
    public List<Exam> listExamsByCategory(Category category) {
        return this.examRepository.findByCategory(category);
    }

    @Override
    public List<Exam> listExamActive() {
        return examRepository.findByActive(true);
    }

    @Override
    public List<Exam> listExamActiveByCategory(Category category) {
        return examRepository.findByCategoryAndActive(category, true);
    }


}
