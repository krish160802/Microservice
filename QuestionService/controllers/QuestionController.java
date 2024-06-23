package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Quesion;
import com.example.demo.services.QuestionService;

@RestController

public class QuestionController {
	
	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	@PostMapping
	public Quesion create(@RequestBody Quesion question) {
		return questionService.create(question);
	}
	
	@GetMapping("/question")
	public List<Quesion> getAll(){
		return questionService.get();
	}
	
	@GetMapping("/question/{questionId}")
	public Quesion getAll(@PathVariable Long questionId){
		return questionService.getOne(questionId);
	}
	
	@GetMapping("/question/quiz/{quizId}")
	public List<Quesion> getQuestionsOfQuiz(@PathVariable Long quizId){
		return questionService.getQuestionsOfQuiz(quizId);
	}
}
