package com.mysite.mysite.service;

import com.mysite.mysite.dto.QuestionDto;
import com.mysite.mysite.entity.Question;
import com.mysite.mysite.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Long createQuestion(QuestionDto dto){
        Question question = new Question();
        question.setTitle(dto.getTitle());
        question.setContent(dto.getContent());
        return questionRepository.save(question).getId();
    }

    public List<QuestionDto> getQuestionList(){
        List<Question> questionList = questionRepository.findAll();

        return questionList.stream().map(QuestionDto::fromEntity).toList();
    }

    public QuestionDto getQuestionDetail(Long id){
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isEmpty()) throw new RuntimeException("질문 엔티티 없음");
        return QuestionDto.fromEntity(optionalQuestion.get());
    }
}
