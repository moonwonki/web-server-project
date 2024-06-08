package com.mysite.mysite.dto;

import com.mysite.mysite.entity.Answer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AnswerDto {

    private Long id;
    private String content;
    private String createDate;

    public static AnswerDto fromEntity(Answer answer){
        AnswerDto dto = new AnswerDto();
        dto.setId(answer.getId());
        dto.setContent(answer.getContent());
        dto.setCreateDate(answer.getCreateDate());
        return dto;
    }
}
