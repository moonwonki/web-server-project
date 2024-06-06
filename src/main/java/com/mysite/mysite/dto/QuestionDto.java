package com.mysite.mysite.dto;

import com.mysite.mysite.entity.Question;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class QuestionDto {
    private Long id;
    private String title;
    private String content;

    public static QuestionDto fromEntity(Question question){
        QuestionDto dto = new QuestionDto();
        dto.setId(question.getId());
        dto.setTitle(question.getTitle());
        dto.setContent(question.getContent());
        return dto;
    }
}
