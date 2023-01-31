package com.system.exams.service;

import com.system.exams.entity.Exam;

import java.util.Set;

public interface ExamService {

    Exam createExam(Exam exam);

    Exam upDateExam(Exam exam);

    Set<Exam> getExams();

    Exam getExam(int examId);

    void deleteExam(int examId);
}
