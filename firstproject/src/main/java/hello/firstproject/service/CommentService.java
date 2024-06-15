package hello.firstproject.service;

import hello.firstproject.dto.CommentDto;
import hello.firstproject.entity.Article;
import hello.firstproject.entity.Comment;
import hello.firstproject.repository.ArticleRepository;
import hello.firstproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;




    public List<CommentDto> comments(Long articleId) {
        /*
        //1. 댓글 조회
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        //2. 엔티티 -> DTO 변환
        List<CommentDto> dtos = new ArrayList<>();
        for (Comment c : comments) {
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }

        // 3. 결과 반환
        return dtos;
        */
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(CommentDto::createCommentDto)
                .toList();

    }
    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        // 1. 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(()-> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다"));
        // 2. 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);
        // 3. 댓글 엔티티를 DB에 저장
        Comment created = commentRepository.save(comment);
        // 4. DTO로 변환해 반환
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        // 1.댓글 조회 예외발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다"));
        // 2.댓글 수정
        target.patch(dto);
        // 3.DB 갱신
        Comment updated = commentRepository.save(target);
        // 4.댓글 엔티티를 DT0 변환 반환
        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        // 1. 댓글 조회 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상 댓글이 없습니다"));
        // 2. 댓글 삭제
        commentRepository.delete(target);
        // 3. 삭제 댓글을 DT0 변환 반환
        return CommentDto.createCommentDto(target);
    }
}
