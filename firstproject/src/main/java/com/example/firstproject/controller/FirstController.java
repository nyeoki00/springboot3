package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 어노테아션(annotation)이란 소스 코드에 추가해 사용하는 메타 데이터의 일종
// 메타 데이터는 프로그램 에서 처리해야 할 데이터가 아니라
// 컴파일 및 실행 과정에서 코드를 어떻게 처리해야 할지 알려 주는 추가 정보를 의미
@Controller
public class FirstController {

    @GetMapping("/hi")  // url 요청 접수
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "Alex");
        return "greetings"; // greetings.mustache 반환
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "홍길동");
        return "goodbye";
    }
}
