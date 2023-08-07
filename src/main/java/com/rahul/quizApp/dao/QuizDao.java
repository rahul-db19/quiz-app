package com.rahul.quizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.quizApp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{
	

}
