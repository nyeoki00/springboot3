package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor // lombok
public class ArticleForm {
    private Long id;
    private String title;
    private String content;


    // 전송받은 제목과 내용을 필드에 저장하는 생성자
//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

    // 데이터를 잘 받았는지 확인할 toString() 메서드장
//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    // toEntityO 메서드에서는 폼 데이터를 담은 DTO 객체를 엔티티로 반환(return new Article()；)
    // 전달값은 Article 클래스의 생성자 형식에 맞게 작성
    // Article.java에서 생성자를 확인해 보면 id, title, content를 매개변수로 받고 있음
    // 아직 ArticleForm 객체에 id 정보는 없으므로
    // 첫 번째 전달값은 null. 두 번째 전달값은 title. 세 번째 전달값은 content를 입력
    public Article toEntity() {
        return new Article(id, title, content);
    }
}
