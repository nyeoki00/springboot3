package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor  // 생성자 추가 어노테이션
@NoArgsConstructor  // 기본생성자 추가 어노테이션
@ToString
@Data  // Getter, Setter
public class Article {
    @Id // Entity의 대표값 지정 (PK)
    @GeneratedValue // 자동 생성 기능 추가 (MySQL의 Auto Increment)
    private Long id;

    @Column  // title 필드 선언, DB table의 title 열과 연결됨
    private String title;

    @Column // content 필드 선언, DB table의 content 열과 연결됨
    private String content;

    // Constructor 생성자
//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }

    // override toString() method

//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
}
