package hello.firstproject.api;

import hello.firstproject.dto.ArticleForm;
import hello.firstproject.entity.Article;
import hello.firstproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ArticleApiController {
    private final ArticleRepository articleRepository;
    // Get
    @GetMapping("/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }
    // Post

    @PostMapping("/articles")
    public Article create(@RequestBody ArticleForm dto){
        log.info("{}",dto);
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }
    // PATCH

    @PatchMapping("/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,
                          @RequestBody ArticleForm dto){
        // 1. DTO -> 엔티티 변환하기
        Article article = dto.toEntity();
        log.info("id： {}, article： {}", id, article.toString());
        // 2. 타깃 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리하기
        if(target==null || !id.equals(article.getId())){
            // 400 잘못된 요청 응답
            log.info("잘못된 요청! id： {}, article： {}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 4. 업데이트 및 정상 응답(200)하기
        //Article updated = articleRepository.save(article);
        target.patch(article);
        Article updated = articleRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
        
    }
    // DELETE
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        // 1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if(target ==null || !id.equals(target.getId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 3. 대상 삭제하기
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
