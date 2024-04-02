package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	private QuizService quizService;

	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}

	@PostMapping("/")
	public Quiz createQuiz(@RequestBody Quiz quiz) {

		return quizService.createQuiz(quiz);

	}

	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable Integer quizId) {

		return quizService.getquiz(quizId);
	}

	@GetMapping("/")
	public List<Quiz> getAllQuiz() {

		return quizService.getAllQuiz();
	}

}
