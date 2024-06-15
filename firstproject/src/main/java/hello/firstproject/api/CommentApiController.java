package hello.firstproject.api;

import hello.firstproject.dto.CommentDto;
import hello.firstproject.entity.Comment;
import hello.firstproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentApiController {

    private final CommentService commentService;

    // 1. 댓글 조회
    @GetMapping("/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId){
        List<CommentDto> dtos = commentService.comments(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 2. 댓글 생성
    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,
                                             @RequestBody CommentDto dto){
        // 서비스에 위임
        CommentDto createdDto = commentService.create(articleId, dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @PatchMapping("/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id,
                                             @RequestBody CommentDto dto){
        // 서비스에 위임
        CommentDto updatedDto = commentService.update(id, dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id){
        // 서비스에 위임
        CommentDto deletedDto = commentService.delete(id);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }




    // 3. 댓글 수정
    // 3. 댓글 삭제
}
