package com.example.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Quesion;
import com.example.demo.repositories.QuestionRepository;
import com.example.demo.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	private QuestionRepository questionRepository;
	
	

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public Quesion create(Quesion question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
	}

	@Override
	public List<Quesion> get() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	@Override
	public Quesion getOne(Long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
	}

	@Override
	public List<Quesion> getQuestionsOfQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuizId(quizId);
	}

}
