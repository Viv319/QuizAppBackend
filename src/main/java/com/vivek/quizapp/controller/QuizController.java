package com.vivek.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.vivek.quizapp.model.QuestionWrapper;
import com.vivek.quizapp.model.Response;
import com.vivek.quizapp.serivce.QuizService;

@RestController
@CrossOrigin
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam  String title){
		return quizService.createQuiz(category,numQ ,title);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id) {
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public  ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
		return quizService.calculateResult(id, response);
	}
}
