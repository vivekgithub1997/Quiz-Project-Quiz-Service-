package com.quiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.payload.binding.RequestForQuestions;
import com.quiz.repo.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	private QuizRepository quizRepository;

	private RequestForQuestions requestForQuestions;

	public QuizServiceImpl(QuizRepository quizRepository, RequestForQuestions requestForQuestions) {
		super();
		this.quizRepository = quizRepository;
		this.requestForQuestions = requestForQuestions;
	}

	@Override
	public Quiz createQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);

	}

	@Override
	public Quiz getquiz(Integer quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz Not Found...!!"));

		quiz.setQuestion(requestForQuestions.getAllQuestionsBasedOnQuiz(quiz.getQuizId()));
		return quiz;
	}

	@Override
	public List<Quiz> getAllQuiz() {
		// TODO Auto-generated method stub
		List<Quiz> allQuiz = quizRepository.findAll();
		List<Quiz> AllQuizWithQuestions = allQuiz.stream().map(quiz -> {

			quiz.setQuestion(requestForQuestions.getAllQuestionsBasedOnQuiz(quiz.getQuizId()));
			return quiz;

		}).collect(Collectors.toList());
		return AllQuizWithQuestions;
	}

}
