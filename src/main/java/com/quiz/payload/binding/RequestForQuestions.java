package com.quiz.payload.binding;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9092", value = "Questions-cleint"  )
public interface RequestForQuestions {
	
	@GetMapping("/question/quiz/{quizId}")
	List<Question> getAllQuestionsBasedOnQuiz(@PathVariable Integer quizId);
	

}
