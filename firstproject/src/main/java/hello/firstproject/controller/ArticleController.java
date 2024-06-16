package hello.firstproject.controller;

import hello.firstproject.dto.ArticleForm;
import hello.firstproject.dto.CommentDto;
import hello.firstproject.entity.Article;
import hello.firstproject.repository.ArticleRepository;
import hello.firstproject.repository.CommentRepository;
import hello.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;

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
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);


        //모델에 데이터 등록하기
        model.addAttribute("article",articleEntity);
        model.addAttribute("commentDtos", commentDtos);
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

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",articleEntity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info("ArticleForm DTO : {}",form);
        // 1. DTO를 엔티티로 변환하기
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
        // 2. 엔티티를 DB에 저장하기
        // 2-1. DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        if(target != null){
            articleRepository.save(articleEntity);
        }
        // 3. 수정 결과 페이지로 리다이렉트하기
        return "redirect:/articles/"+articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청이 들어왔습니다");
        // 1. 삭제할 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        // 2. 대상 엔티티 삭제하기
        if(target != null){
            articleRepository.delete(target);
        }
        rttr.addFlashAttribute("msg","삭제됐습니다!");
        // 3. 결과페이지로 리다이렉트하기

        return "redirect:/articles";
    }

}
