package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired // DI
    private ArticleRepository articleRepository;

    // GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {  // @RequestBody: 클라이언트가 body에 실어 보내는 데이터를 create메서드의 매개변수로 받아옴
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }
    // PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        // 1. DTO -> Entity 변환
        // 2. 타깃 조회
        // 3. 잘못된 요청 처리
        // 4. 업데이트 및 정상 응답(200)

        // 1
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 2
        Article target = articleRepository.findById(id).orElse(null);

        // 3
        if (target == null || id != article.getId()) {
            // http response 400
            log.info("잘못된 요청! id : {}, article: {}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
            // ResponseEntity는 REST 컨트롤러의 반환형 , 즉 REST API의 응답을 위해 사용하는 클래스
            // REST API 요청을 받아 응답할 때 이 클래스에 HTTP 상태 코드 헤더. 본문을 실어 보낼 수 있음
        }

        // 4
        target.patch(article); // 기존 데이터에 새 데이터 붙이기
        Article updated = articleRepository.save(target); // article Entity DB에 저장
        return ResponseEntity.status(HttpStatus.OK).body(updated); // 정상 응답
    }

    // DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        // 1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        // 3. 대상 삭제하기
        articleRepository.delete(target);
        // return ResponseEntity.status(HttpStatus.OK).body(null); // 추가한게 아니기 때문에 null 리턴
        return ResponseEntity.status(HttpStatus.OK).build(); // body(null) == build() 같음
    }
}
