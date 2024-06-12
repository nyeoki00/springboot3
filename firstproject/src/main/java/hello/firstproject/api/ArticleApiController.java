package hello.firstproject.api;

import hello.firstproject.dto.ArticleForm;
import hello.firstproject.entity.Article;
import hello.firstproject.repository.ArticleRepository;
import hello.firstproject.service.ArticleService;
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
    private final ArticleService articleService; // 서비스 객체 주입

    private final ArticleRepository articleRepository;
    // Get
    @GetMapping("/articles")
    public List<Article> index(){
        return articleService.index();
    }

    @GetMapping("/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }
    // Post

    @PostMapping("/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        log.info("{}",dto);
        Article created = articleService.create(dto);
        return (created != null)?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
     //PATCH

    @PatchMapping("/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,
                          @RequestBody ArticleForm dto){
        Article updated=articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // DELETE
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted =articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("transaction-test")
    public ResponseEntity<List<Article>> transactionTest
            (@RequestBody List<ArticleForm> dtos){
        List<Article> createdList =articleService.createArticles(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
