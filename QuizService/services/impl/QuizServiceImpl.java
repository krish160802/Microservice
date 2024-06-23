package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Quiz;
import com.example.demo.repositories.QuizRepository;
import com.example.demo.services.QuestionClient;
import com.example.demo.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	private QuizRepository quizRepository;
	private QuestionClient questionClient;
	
	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}


	@Override
	public Quiz add(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		// TODO Auto-generated method stub
		List<Quiz> newQuizList = quizRepository.findAll();
		
		newQuizList.stream().map(quiz->{
			quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuizList;
	}

	@Override
	public Quiz getOne(Long id) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
		return quiz;
				
	}

}
