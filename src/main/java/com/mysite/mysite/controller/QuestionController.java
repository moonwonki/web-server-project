package com.mysite.mysite.controller;

import com.mysite.mysite.dto.QuestionDto;
import com.mysite.mysite.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questionList")
    public String questionList(Model model){
        model.addAttribute("questionList", questionService.getQuestionList());
        return "/questionList";
    }

    @GetMapping("/question/detail/{questionId}")
    public String questionDetail(@PathVariable("questionId") Long questionId, Model model){
        model.addAttribute("question", questionService.getQuestionDetail(questionId));
        return "/questionDetail";
    }


    @GetMapping("/question/upload")
    public String questionForm(Model model){
        return "questionForm";
    }
    @PostMapping("/question/upload")
    public String questionUpload(QuestionDto dto){
        Long questionId = questionService.createQuestion(dto);
        return "redirect:/question/detail/" + questionId;
    }


}
