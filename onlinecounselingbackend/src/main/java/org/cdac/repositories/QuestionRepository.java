package org.cdac.repositories;

import java.util.List;

import org.cdac.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	@Query("SELECT q FROM Question q WHERE q.questType =?1")
    public List<Question> getQuestionPaper(String questionsType);
}
