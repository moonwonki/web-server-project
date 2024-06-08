package com.mysite.mysite.controller;

import com.mysite.mysite.dto.AnswerDto;
import com.mysite.mysite.service.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/answer/create/{questionId}")
    public String createAnswer(@PathVariable("questionId") Long questionId, AnswerDto dto) {
        answerService.createAnswer(dto, questionId);
        return "redirect:/detail/" + questionId;
    }
}
