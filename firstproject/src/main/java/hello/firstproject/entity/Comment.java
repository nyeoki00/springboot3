package hello.firstproject.entity;

import hello.firstproject.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 대표키
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;// 해당 댓글의 부모 게시글
    private String nickname; //댓글을 단 사람
    private String body; //댓글 본문

    public static Comment createComment(CommentDto dto, Article article) {
        // 예외 발생
        if(dto.getId() !=null){
            // 의도적으로 IllegalArgumentException 예외 발생
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id 없어야 합니다");
        }
        if (dto.getArticleId() != article.getId()) {
            System.out.println(dto);
            System.out.println(article);
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됐습니다");
        }
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody());
    }

    public void patch(CommentDto dto) {
        // 예외 발생
        if(id != dto.getId()){
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력됐습니다");
        }
        //갱신
        if(dto.getNickname() != null){ // 수정할 닉네임 데이터가 있다면
            nickname= dto.getNickname(); //내용 반영
        }
        if(dto.getBody() != null){ // 수정할 본문 데이터가 있다면
            body= dto.getBody(); //내용 반영
        }
    }
}
