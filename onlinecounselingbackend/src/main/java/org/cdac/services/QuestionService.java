package org.cdac.services;

import java.util.List;

import org.cdac.DTO.QuestionDTO;



public interface QuestionService {

	public boolean insertQuestion(QuestionDTO objQuestionDTO);
	public List<QuestionDTO> allQuestions();
	public QuestionDTO findByQuestion(int questionNo);
	public boolean updateQuestion(QuestionDTO objQuestionDTO);
	public boolean deleteQuestion(int questNo);
	public List<QuestionDTO> findByQuestionType(String questionPaperType);
}
