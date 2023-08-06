package com.rahul.quizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.quizApp.Question;
import com.rahul.quizApp.dao.QuestionDao;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity< List<Question>> findAllQuestions(){
    	try {
    		return new ResponseEntity<> (questionDao.findAll(),HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new ResponseEntity<> (new ArrayList<>() ,HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity< List<Question>> getQuestionsByCategory(String category) {
        
        try {
        	return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new ResponseEntity<> (new ArrayList<>() ,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question questions) {
        
        try {
        	questionDao.save(questions);
            return new ResponseEntity<>("success",HttpStatus.CREATED);		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new ResponseEntity<> ("Couldn't add question",HttpStatus.BAD_REQUEST);
    }
}
