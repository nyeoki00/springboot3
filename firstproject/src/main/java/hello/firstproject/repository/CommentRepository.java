package hello.firstproject.repository;

import hello.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 특정게시글의 모든 댓글 조회
    @Query(value = "SELECT * FROM comment WHERE article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);

    // 특정닉네임의 모든 댓글 조회 (xml)
    List<Comment> findByNickname(String nickname);

    // 특정닉네임의 모든 댓글 조회 (JPQL)
    @Query(value = "select c from Comment as c where c.nickname = :nickname")
    List<Comment> findByNickname2(String nickname);
}
