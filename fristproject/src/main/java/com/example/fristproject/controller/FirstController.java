package com.example.fristproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "현종종님");
        return "greetings";
    }

    @GetMapping("bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "hyunjong");
        return "goodbye";
    }
}
