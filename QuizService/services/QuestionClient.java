package com.example.demo.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Quesion;

@FeignClient(url = "http://localhost:8082",value="Question-Client")
public interface QuestionClient {
	
	
	@GetMapping("/api/question/quiz/{quizId}")
	List<Quesion>getQuestionsOfQuiz(@PathVariable Long quizId);
}
