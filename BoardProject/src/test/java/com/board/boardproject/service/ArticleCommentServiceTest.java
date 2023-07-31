package com.board.boardproject.service;

import com.board.boardproject.domain.Article;
import com.board.boardproject.dto.ArticleCommentDto;
import com.board.boardproject.dto.UserAccountDto;
import com.board.boardproject.repository.ArticleCommentRepository;
import com.board.boardproject.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService articleCommentService;
    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 ID 조회 -> 댓글 리스트 반환")
    @Test
    void ArticleId_SearchingArticleComments_ReturnsArticleComments(){
        Long articleId = 1L;
        UserAccountDto userAccountDto = new UserAccountDto(null, null, null, null, null, LocalDateTime.now(), null, LocalDateTime.now(), null);

        BDDMockito.given(articleRepository
                .findById(articleId))
                .willReturn(Optional.of(Article.of(userAccountDto.toEntity(), "title","content","hashtag")));

        List<ArticleCommentDto> articleComments = articleCommentService.searchArticleComment(articleId);

        assertThat(articleComments).isNotNull();
        BDDMockito.then(articleRepository).should().findById(articleId);
    }
}