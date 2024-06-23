package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Quiz;
import com.example.demo.services.QuizService;

@RestController
public class QuizController {
	
	private QuizService quizService;

	public QuizController(QuizService quizService) {

		this.quizService = quizService;
	}
	
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}
	
	@GetMapping("/quiz")
	public List<Quiz> get(){
		return quizService.get();
	}
	
	@GetMapping("/quiz/{id}")
	public Quiz getOne(@PathVariable Long id) {
		return quizService.getOne(id);
	}
}
