package org.cdac.controllers;

import java.util.List;

import org.cdac.DTO.QuestionDTO;
import org.cdac.DTO.UserDTO;
import org.cdac.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questService;
	
	@PostMapping("/insertquestion")
	public boolean insertQuestion(@RequestBody QuestionDTO objQuestionDTO) {
		return questService.insertQuestion(objQuestionDTO);
	}
	
	@GetMapping("/allquestions")
	public List<QuestionDTO> allUsers() {
		return questService.allQuestions();
	}
	
	@PostMapping("/updatequestion")
	public boolean updateQuestion(@RequestBody QuestionDTO objQuestionDTO)
	{
		return questService.updateQuestion(objQuestionDTO);
			
	}
	
	

}
