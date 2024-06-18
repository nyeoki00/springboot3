package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Slf4j // println대신 데이터 검증에 사용하는 log4j
@Controller
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입 (DI, Dependency Injection)
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;


    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }


    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) { // form data를 DTO로 받기
        // System.out.println("form.toString()" + form.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인
        log.info("form.toString : " + form.toString());
        // 1. DTO를 Entity로 변환
        Article article = form.toEntity();
        // System.out.println("article.toString()" + article.toString());
        log.info("article.toString()" + article.toString());
        // 2. Repository로 Entity를 DB에 저장
        Article saved = articleRepository.save(article);
        // System.out.println("saved.toString()" + saved.toString());
        log.info("saved.toString()" + saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    // 디테일 페이지
    @GetMapping("/articles/{id}") // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model) {  // @PathVariable : URL 요청으로 들어온 전달값을 컨트롤러의 매개변수로 가져오는 어노테이션
        log.info("id : " + id);
        // 1. id를 조회해서 데이터 가져오기 (데이터는 리파지토리로 가져옴)
        // Optional<Article> articleEntity = articleRepository.findById(id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 댓글 목록 가져오기
        List<CommentDto> commentsDtos = commentService.comments(id);

        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentsDtos);

        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }

    // 전체 목록
    @GetMapping("/articles")
    public String index(Model model) {
        // 1. DB에서 모든 Article 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll(); // findaAll() 메서드의 반환타입은 Iterable / ArticleRepository에서 findAll override

        // 2. 가져온 Article 묶음을 모델에 등록
        model.addAttribute("articleList", articleEntityList);

        // 3. 사용자에게 보여 줄 뷰 페이지 설정
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 모델에 데이터 등록
        model.addAttribute("article", articleEntity);
        // 뷰 페이지 설정
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        log.info("form.toString()" + form.toString());

        Article articleEntity = form.toEntity();
        log.info("articleEntity.toString : " + articleEntity.toString());

        // DB에서 수정할 기본 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        // 기존 데이터 값을 갱신
        if (target != null) {
            articleRepository.save(articleEntity);  // Entitiy를 DB에 저장 (갱신, update)
        }
        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) { // RedirectAttributes 객체로 리다이렉트 페이지에서 사용할 데이터를 남길 수 있음, 한 번 쓰고 사라지는 휘발성 데이터
        log.info("삭제 요청이 들어왔습니다.");
        // 1. 삭제할 대상 가져오기
        // 2. 대상 엔티티 삭제하기
        // 3. 결과 페이지로 리다이렉트
        Article target = articleRepository.findById(id).orElse(null); // 1
        log.info(target.toString());

        if (target != null) { // 2
            articleRepository.delete(target);
            log.info("삭제 완료");
            rttr.addFlashAttribute("msg", "Delete Done");
        }

        return "redirect:/articles";
    }

}