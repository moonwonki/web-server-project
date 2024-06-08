package com.mysite.mysite.dto;

import com.mysite.mysite.entity.Answer;
import com.mysite.mysite.entity.Question;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class QuestionDto {
    private Long id;
    private String subject;
    private String content;
    private String createDate;
    private List<Answer> answerSet = new ArrayList<>();

    public static QuestionDto fromEntity(Question question){
        QuestionDto dto = new QuestionDto();
        dto.setId(question.getId());
        dto.setSubject(question.getSubject());
        dto.setContent(question.getContent());
        dto.setCreateDate(question.getCreateDate());
        dto.setAnswerSet(question.getAnswerSet());
        return dto;
    }
}
