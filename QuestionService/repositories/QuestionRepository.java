package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Quesion;

public interface QuestionRepository extends JpaRepository<Quesion,Long>{
	List<Quesion> findByQuizId(Long quizId);
}
