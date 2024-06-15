package hello.firstproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import hello.firstproject.entity.Article;
import hello.firstproject.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    @JsonProperty("article_id")
    private Long articleId;
    private String nickname;
    private String body;


    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody());
    }
}
