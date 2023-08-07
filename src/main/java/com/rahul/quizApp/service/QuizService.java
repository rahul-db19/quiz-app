package com.rahul.quizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rahul.quizApp.model.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.quizApp.dao.QuestionDao;
import com.rahul.quizApp.dao.QuizDao;
import com.rahul.quizApp.model.Question;
import com.rahul.quizApp.model.Quiz;
@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestion();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();

		for(Question q : questionsFromDB){
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}
}
