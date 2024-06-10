package hello.firstproject.dto;

import hello.firstproject.entity.Article;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleForm {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null,this.title,this.content);
    }
}
