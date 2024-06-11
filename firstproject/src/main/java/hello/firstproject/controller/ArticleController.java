package hello.firstproject.controller;

import hello.firstproject.dto.ArticleForm;
import hello.firstproject.entity.Article;
import hello.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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
        return "redirect:/articles/"+saved.getId();
    }

    @GetMapping("/articles/{id}") //데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model){
        log.info("id : {}",id);
        // id를 조회해 데이터를 가져오기
        Optional<Article> articleEntity = articleRepository.findById(id);
        //모델에 데이터 등록하기
        model.addAttribute("article",articleEntity.orElse(null));
        // 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        // 1. DB에서 모든 Article 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 가져온 Article 묶음을 모델로 등록하기
        model.addAttribute("articleList",articleEntityList);
        // 3. 사용자에게 보여줄 뷰 페이지 설정하기
        return "articles/index";
    }

}
