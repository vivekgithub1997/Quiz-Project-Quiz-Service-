package com.quiz.services;

import java.util.List;

import com.quiz.entity.Quiz;

public interface QuizService {

	Quiz createQuiz(Quiz quiz);

	Quiz getquiz(Integer quizId);

	List<Quiz> getAllQuiz();

}
