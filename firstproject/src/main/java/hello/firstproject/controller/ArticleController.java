package hello.firstproject.controller;

import hello.firstproject.dto.ArticleForm;
import hello.firstproject.entity.Article;
import hello.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info("ArticleForm DTO : {}",form);
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info("Article 엔티티 : {}",article);
        // 2. 리파지터리를 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info("DB에 저장된 Article 엔티티 : {}",saved);
        return "articles/new";
    }

}
