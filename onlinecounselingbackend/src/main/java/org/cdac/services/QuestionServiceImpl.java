package org.cdac.services;


import java.util.ArrayList;
import java.util.List;
import org.cdac.DTO.QuestionDTO;
import org.cdac.DTO.UserDTO;
import org.cdac.entity.Question;
import org.cdac.entity.User;
import org.cdac.repositories.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	@Autowired
	QuestionRepository questRepo;
	
	@Override
	public boolean insertQuestion(QuestionDTO objQuestionDTO) {
		try {
			Question entityQuestion=new Question();
			BeanUtils.copyProperties(objQuestionDTO, entityQuestion);
			questRepo.save(entityQuestion); 
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<QuestionDTO> allQuestions() {
		List<Question> allQuestions=questRepo.findAll();
		List<QuestionDTO> questions=new ArrayList<>();
		for(Question objQuestion:allQuestions)
		{
			QuestionDTO objQuestionDTO=new QuestionDTO();
			BeanUtils.copyProperties(objQuestion, objQuestionDTO);
			questions.add(objQuestionDTO);
		}
		return questions;
	}

	@Override
	public QuestionDTO findByQuestion(int questionNo) {
		Question objQuestion=questRepo.getOne(questionNo);
		QuestionDTO objQuestionDTO=new QuestionDTO();
		BeanUtils.copyProperties(objQuestion, objQuestionDTO);
		return objQuestionDTO;
		
	}

	@Override
	public boolean updateQuestion(QuestionDTO objQuestionDTO) {
		int qNo=objQuestionDTO.getQuestNo();
		Question objQuestion=questRepo.getOne(qNo);
		BeanUtils.copyProperties(objQuestionDTO, objQuestion);
		questRepo.save(objQuestion);
		return true;
	}

	@Override
	public boolean deleteQuestion(int questNo) {
		QuestionDTO objDTO=findByQuestion(questNo);
		Question objQuestion=new Question();
		BeanUtils.copyProperties(objDTO,objQuestion);
		questRepo.delete(objQuestion);
		return true;
		
	}

	@Override
	public List<QuestionDTO> findByQuestionType(String q_type) {
		
		
		List<Question> allQuestions=questRepo.getQuestionPaper(q_type);
		List<QuestionDTO> questions=new ArrayList<>();
		for(Question objQuestion:allQuestions)
		{
			QuestionDTO objQuestionDTO=new QuestionDTO();
			BeanUtils.copyProperties(objQuestion, objQuestionDTO);
			questions.add(objQuestionDTO);
		}
		return questions;
	}

	
	

}
