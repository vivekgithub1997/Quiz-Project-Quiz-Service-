package com.quiz.payload.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	private Integer questionId;
	private String questionTitle;
	private Integer quizId;

}
