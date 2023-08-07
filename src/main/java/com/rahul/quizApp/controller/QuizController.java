package com.rahul.quizApp.controller;

import com.rahul.quizApp.model.Question;
import com.rahul.quizApp.model.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rahul.quizApp.service.QuizService;

import java.util.List;


@RestController
@RequestMapping(value="/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title){
		return quizService.createQuiz(category,numQ,title);	
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
		return quizService.getQuizQuestions(id);
	}
}