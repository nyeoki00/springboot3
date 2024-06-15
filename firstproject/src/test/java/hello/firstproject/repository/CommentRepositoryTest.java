package hello.firstproject.repository;

import hello.firstproject.entity.Article;
import hello.firstproject.entity.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest //해당 클래스를 JPA와 연동해 테스트
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1 : 4번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long id = 4L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(id);
            // 3. 예상 데이터
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 고");
            Comment a = new Comment(1L, article, "Park", "굿 윌 헌팅");
            Comment b = new Comment(2L, article, "Kim", "아이 엠 샘");
            Comment c = new Comment(3L, article, "Choi", "쇼생크 탈출");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 4. 비교 검증
            assertThat(comments.toString()).isEqualTo(expected.toString());

        }
        /* Case 2 : 9번 게시글의 모든 댓글 조회 */
        {
            Long articleId=9L;
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            assertThat(comments).isEqualTo(expected);
        }

        /* Case 3 : 999번 게시글의 모든 댓글 조회 */
        {
            Long articleId=999L;
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            assertThat(comments).isEqualTo(expected);
        }

        /* Case 4 : -1번 게시글의 모든 댓글 조회 */
        {
            Long articleId=-1L;
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            assertThat(comments).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1 : "Kim"의 모든 댓글 조회 */
        {
            String Nickname="Kim";
            Article article4 = new Article(4L, "당신의 인생 영화는?", "댓글 고");
            Article article5 = new Article(5L, "당신의 소울 푸드는?", "댓글 고고");
            Article article6 = new Article(6L, "당신의 취미는?", "댓글 고고고");

            Comment a = new Comment(2L, article4, "Kim", "아이 엠 샘");
            Comment b = new Comment(5L, article5, "Kim", "샤브샤브");
            Comment c = new Comment(8L, article6, "Kim", "유튜브 시청");
            List<Comment> expected = List.of(a,b,c);
            List<Comment> comments = commentRepository.findByNickname(Nickname);

            assertThat(comments.toString()).isEqualTo(expected.toString());
        }

        /* Case 2 : null의 모든 댓글 조회 */
        {
            String Nickname=null;
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByNickname(Nickname);

            assertThat(comments.toString()).isEqualTo(expected.toString());
        }

        /* Case 3 : null의 모든 댓글 조회 */
        {
            String Nickname=null;
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByNickname(Nickname);

            assertThat(comments.toString()).isEqualTo(expected.toString());
        }

        /* Case 3 : ""의 모든 댓글 조회 */
        {
            String Nickname="";
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByNickname(Nickname);

            assertThat(comments.toString()).isEqualTo(expected.toString());
        }
    }

    @Test
    @DisplayName("JPQL 문법")
    void findByNickname2() {
        /* Case 1 : "Kim"의 모든 댓글 조회 */
        {
            String Nickname="Kim";
            Article article4 = new Article(4L, "당신의 인생 영화는?", "댓글 고");
            Article article5 = new Article(5L, "당신의 소울 푸드는?", "댓글 고고");
            Article article6 = new Article(6L, "당신의 취미는?", "댓글 고고고");

            Comment a = new Comment(2L, article4, "Kim", "아이 엠 샘");
            Comment b = new Comment(5L, article5, "Kim", "샤브샤브");
            Comment c = new Comment(8L, article6, "Kim", "유튜브 시청");
            List<Comment> expected = List.of(a,b,c);
            List<Comment> comments = commentRepository.findByNickname(Nickname);

            assertThat(comments.toString()).isEqualTo(expected.toString());
        }

        /* Case 2 : null의 모든 댓글 조회 */
        {
            String Nickname=null;
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByNickname(Nickname);

            assertThat(comments.toString()).isEqualTo(expected.toString());
        }

        /* Case 3 : null의 모든 댓글 조회 */
        {
            String Nickname=null;
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByNickname(Nickname);

            assertThat(comments.toString()).isEqualTo(expected.toString());
        }

        /* Case 3 : ""의 모든 댓글 조회 */
        {
            String Nickname="";
            List<Comment> expected = List.of();
            List<Comment> comments = commentRepository.findByNickname(Nickname);

            assertThat(comments.toString()).isEqualTo(expected.toString());
        }
    }
}