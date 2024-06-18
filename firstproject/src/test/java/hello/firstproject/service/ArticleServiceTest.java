package hello.firstproject.service;

import hello.firstproject.dto.ArticleForm;
import hello.firstproject.entity.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest //해당 클래스를 스프링 부트와 연동해 테스트
@Transactional
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    @Transactional(readOnly = true)
    void index() {
        // 1. 예상 데이터
        Article a = new Article(1L,"가가가가","1111");
        Article b = new Article(2L,"나나나나","2222");
        Article c = new Article(3L,"다다다다","3333");
        List<Article> expected = new ArrayList<>(Arrays.asList(a,b,c));

        // 2. 실제 데이터
        List<Article> articles = articleService.index();
        // 3. 비교 및 검증
        assertEquals(expected.toString(),articles.toString());
    }

    @Test
    @DisplayName("show_성공_존재하는_id_입력")
    void show_성공() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());

    }
    @Test
    @DisplayName("show_실패_존재하지_않는_id_입력")
    void show_실패() {
        // 1. 예상 데이터
        Long id = -1L;
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected,article);
    }

    @Test
    @DisplayName("create_성공_title과_content만_있는_dto_입력()")
    void create_성공(){
        // 1. 예상 데이터
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        // 2. 실제 데이터
        Article article = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString(),article.toString());
    }

    @Test
    @DisplayName("create_실패_id가_포함된_dto_입력()")
    void create_실패(){
        // 1. 예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected,article);
    }

    @Test
    @DisplayName("update_성공_존재하는_id_title_content_있는_dto_입력")
    void update_성공() {
        // 1. 예상 데이터
        Long id=1L;
        String title = "나나나나";
        String content = "2222";
        ArticleForm form = new ArticleForm(id,title,content);
        Article expected = new Article(id, title, content);
        // 2. 실제 데이터
        Article article = articleService.update(1L, form);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @DisplayName("update_성공_존재하는_id_title만_있는_dto_입력")
    void update_성공_2() {
        // 1. 예상 데이터
        Long id=1L;
        String title = "나나나나";
        String content = null;
        ArticleForm form = new ArticleForm(id,title,content);
        Article expected = new Article(id, title, "1111");
        // 2. 실제 데이터
        Article article = articleService.update(1L, form);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @DisplayName("update_실패_존재하지_않는_id의_dto_입력")
    void update_실패() {
        // 1. 예상 데이터
        Long id=-1L;
        String title = "나나나나";
        String content = "2222";
        ArticleForm form = new ArticleForm(id,title,content);
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.update(1L, form);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }

    @Test
    @DisplayName("delete_성공_존재하는_id_입력")
    void delete_성공() {
        // 1. 예상 데이터
        Long id=1L;
        Article expected = new Article(id,"가가가가","1111");
        // 2. 실제 데이터
        Article article = articleService.delete(1L);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }


}