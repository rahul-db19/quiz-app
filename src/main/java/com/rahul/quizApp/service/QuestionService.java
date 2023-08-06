package com.rahul.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.quizApp.Question;
import com.rahul.quizApp.dao.QuestionDao;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> findAllQuestions(){
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question questions) {
        questionDao.save(questions);
        return "success";
    }
}
