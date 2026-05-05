package com.example.crudboar.controller;

import com.example.crudboar.dto.requestdto;
import com.example.crudboar.dto.responsedto;
import com.example.crudboar.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON 데이터를 반환하는 REST API용 컨트롤러
@RequestMapping("/articles")
@RequiredArgsConstructor
public class boardcontroller {

    private final BoardService boardService;

    // 게시글 생성하는거 - (POST)
    @PostMapping
    public ResponseEntity<responsedto> addArticle(@RequestBody requestdto request) {
        Long id = boardService.save(request);
        // 저장된 데이터를 다시 조회해서 응답함
        responsedto response = new responsedto(boardService.findById(id));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 전체 목록 조회하는거 - (GET)
    @GetMapping
    public ResponseEntity<List<responsedto>> findAllArticles() {
        List<responsedto> articles = boardService.findAll()
                .stream()
                .map(responsedto::new)
                .toList();
        return ResponseEntity.ok(articles);
    }

    // 게시글 개별 조회 - (GET)
    @GetMapping("/{articleId}")
    public ResponseEntity<responsedto> findArticle(@PathVariable Long articleId) {
        responsedto response = new responsedto(boardService.findById(articleId));
        return ResponseEntity.ok(response);
    }

    // 게시글 수정  - (PUT)
    @PutMapping("/{articleId}")
    public ResponseEntity<Void> updateArticle(@PathVariable Long articleId, @RequestBody requestdto request) {
        boardService.update(articleId, request);
        return ResponseEntity.ok().build();
    }

    // 5. 게시글 삭제 (DELETE /articles/{articleId})
    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        boardService.delete(articleId);
        return ResponseEntity.noContent().build();
    }
}