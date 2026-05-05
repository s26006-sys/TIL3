package com.example.crudboar.service;

import com.example.crudboar.dto.requestdto;
import com.example.crudboar.entity.Boardentity;
import com.example.crudboar.repository.boardrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final boardrepository boardRepository;

	// 글 저장 로직
	@Transactional
	public Long save(requestdto request) {
		Boardentity board = Boardentity.builder()
				.title(request.title())
				.content(request.content())
				.build();
		return boardRepository.save(board).getIdx();
	}

	// 전체 조회 로직
	public List<Boardentity> findAll() {
		return boardRepository.findAll();
	}

	// 상세 조회 로직
	public Boardentity findById(Long id) {
		return boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
	}


	// 수정 로직
	@Transactional
	public void update(Long id, requestdto request) {
		Boardentity board = boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("수정할 게시글이 없습니다. id=" + id));

		board.update(request.title(), request.content());
	}

	// 삭제 로직
	@Transactional
	public void delete(Long id) {
		Boardentity board = boardRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("삭제할 게시글이 없습니다. id=" + id));

		boardRepository.delete(board);
	}
}