package hello.firstproject.service;

import hello.firstproject.dto.ArticleForm;
import hello.firstproject.entity.Article;
import hello.firstproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service //서비스 객체 생성
@Slf4j
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository; // 게시글 리파지토리 객체 주입

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        // post 는 생성만 하므로 만약 id값이 있다면 null로 반환시켜 잘못된 응답 유도
        if(article.getId()!=null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // 1. DTO -> 엔티티 변환하기
        Article article = dto.toEntity();
        log.info("id： {}, article： {}", id, article.toString());
        // 2. 타깃 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리하기
        if(target==null || !id.equals(article.getId())){
            // 400 잘못된 요청 응답
            log.info("잘못된 요청! id： {}, article： {}", id, article.toString());
            return null;
        }

        // 4. 업데이트 및 정상 응답(200)하기
        //Article updated = articleRepository.save(article);
        target.patch(article);
        return articleRepository.save(target);

    }

    public Article delete(Long id) {
        // 1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if(target == null || !id.equals(target.getId())){
            return null;
        }
        // 3. 대상 삭제하기
        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // 1. dto 묶음（리스트）을 엔티티 묶음（리스트）으로 변환하기
        List<Article> articleList =
                dtos.stream().map(ArticleForm::toEntity).toList();
        // 2. 엔티티 묶음（리스트）을 DB에 저장하기
        articleRepository.saveAll(articleList);
        // 3. 강제로 에러를 발생시키기
        articleRepository.findById(-1L)
                //찾는 데이터가 없으면 예외 발생
                .orElseThrow(()-> new IllegalArgumentException("결제 실패!"));
        // 4. 결과 값 반환하기
        return articleList;

    }
}
