package com.example.firstproject.dto;

import com.example.firstproject.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDto {
    // CommentDto는 Comment（댓글 엔티티）를 담을 그릇. 따라서 Comment의 구조와 같이
    // id（댓글의 id）, articleld（댓글의 부모 id）, nickname（댓글 작성자）, body（댓글 본문）가 필요
    private Long id;
    @JsonProperty("article_id") // JSON 데이터의 key 이름과 이를 받아 저장하는 DTO에 선언된 필드의 변수명이 다를 경우 선언
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getArticle().getId(), comment.getNickname(), comment.getBody());
    }
}
