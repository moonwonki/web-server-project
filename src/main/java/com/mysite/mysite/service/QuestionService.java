package com.mysite.mysite.service;

import com.mysite.mysite.dto.QuestionDto;
import com.mysite.mysite.entity.Question;
import com.mysite.mysite.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Long createQuestion(QuestionDto dto){
        Question question = new Question();
        question.setSubject(dto.getSubject());
        question.setContent(dto.getContent());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm a", Locale.KOREAN);
        String formattedDate = now.format(formatter);
        question.setCreateDate(formattedDate);
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
