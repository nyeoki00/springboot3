package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 제네릭에 Comment 엔티티를 관리하므로 대상 엔티티에는 Comment, 대표키 값의 타입에는 id의 타입인 Long을 넣습니다.

// JPA에서 단순히 CRUD 작업만 한다면 CrudRepository를 사용해도 충분. 하지만
// CRUD 작업에 더해 페이지 처리와 정렬 작업까지 해야 한다면 JpaRepository를 사용하는 것이 좋음


public interface CommentRepository extends JpaRepository<Comment, Long> {
    // native query method : 쿼리를 메서드로 작성 / 직접 작성한 SQL 쿼리를 리파지터리 메서드로 실행
    //                       ©Query 어노테이션을 이용 or orm.xml 파일 이용


    // 특정 게시글의 모든 댓글 조회 (©Query 어노테이션)
    @Query(value = "SELECT * FROM comment WHERE article_id = :articleId", nativeQuery = true) // value 속성에 실행하려는 쿼리 작성
    List<Comment> findByArticleId(Long articleId);

    // 특정 닉네임의 모든 댓글 조회 (orm.xml 파일)
    List<Comment> findByNickname(String nickname);

}
