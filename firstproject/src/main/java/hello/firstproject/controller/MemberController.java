package hello.firstproject.controller;

import hello.firstproject.dto.MemberForm;
import hello.firstproject.entity.Article;
import hello.firstproject.entity.Member;
import hello.firstproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    @GetMapping("/signup")
    public String signup(){
        return "articles/newSelfCheck";
    }

    @PostMapping("/join")
    public String join(MemberForm form){
        Member member = form.toEntity();
        Member save = memberRepository.save(member);
        System.out.println(save);
        return "articles/newSelfCheck";
    }
}
