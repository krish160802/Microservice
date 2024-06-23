package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Quesion;

public interface QuestionService{
	Quesion create(Quesion question);
	List<Quesion> get();
	Quesion getOne(Long id);
	List<Quesion> getQuestionsOfQuiz(Long quizId);
}
