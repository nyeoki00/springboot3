package hello.firstproject.dto;

import hello.firstproject.entity.Article;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id,title,content);
    }
}
