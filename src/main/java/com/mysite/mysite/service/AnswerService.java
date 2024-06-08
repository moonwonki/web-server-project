package com.mysite.mysite.service;

import com.mysite.mysite.dto.AnswerDto;
import com.mysite.mysite.entity.Answer;
import com.mysite.mysite.repository.AnswerRepository;
import com.mysite.mysite.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class AnswerService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public AnswerService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public void createAnswer(AnswerDto dto, Long questionId) {
        Answer answer = new Answer();
        answer.setContent(dto.getContent());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm a", Locale.KOREAN);
        String formattedDate = now.format(formatter);
        answer.setCreateDate(formattedDate);
        answer.setQuestion(questionRepository.findById(questionId).get());
        answerRepository.save(answer);
    }
}
