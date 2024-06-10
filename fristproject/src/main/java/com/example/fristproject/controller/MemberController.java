package com.example.fristproject.controller;

import com.example.fristproject.dto.MemberForm;
import com.example.fristproject.entity.Member;
import com.example.fristproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/signup")
    public String signup() {
        return "/members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form) {
        log.info(form.toString());
        // System.out.println(form.toString());

        Member member = form.toEntity();
        log.info(member.toString());
        // System.out.println(member.toString());

        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        // System.out.println(saved.toString());
        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable long id, Model model) {
        log.info("id : " + id);
        Member memberEntity = memberRepository.findById(id).orElse(null);

        model.addAttribute("member", memberEntity);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        ArrayList<Member> memberEntityList = memberRepository.findAll();
        model.addAttribute("memberList", memberEntityList);
        return "members/index";
    }

}
