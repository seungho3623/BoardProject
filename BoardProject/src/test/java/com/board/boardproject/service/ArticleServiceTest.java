package com.board.boardproject.service;

import com.board.boardproject.domain.Article;
import com.board.boardproject.domain.SearchType;
import com.board.boardproject.dto.ArticleDto;
import com.board.boardproject.dto.ArticleUpdateDto;
import com.board.boardproject.dto.UserAccountDto;
import com.board.boardproject.repository.ArticleRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService articleService;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 검색 -> 게시글 리스트 반환")
    @Test
    void SearchParameters_SearchingArticles_ReturnsArticleList(){

        Page<ArticleDto> articles = articleService.searchArticles(SearchType.TITLE, "search keyword");

        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 조회 -> 게시글 반환")
    @Test
    void givenId_SearchingArticle_ReturnsArticle(){

        ArticleDto articles = articleService.searchArticles(1L);

        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 정보 입력 -> 게시글 생성")
    @Test
    void ArticleInfo_SavingArticle_SavesArticle(){
        UserAccountDto userAccountDto = new UserAccountDto(null, null, null, null, null, LocalDateTime.now(), null, LocalDateTime.now(), null);
        ArticleDto articleDto = ArticleDto.of(1L, userAccountDto, null, null, null, LocalDateTime.now(), null, LocalDateTime.now(), null);

        given(articleRepository.save(ArgumentMatchers.any(Article.class))).willReturn(null);

        articleService.saveArticle(articleDto);

        BDDMockito.then(articleRepository).should().save(ArgumentMatchers.any(Article.class));
    }

    @DisplayName("게시글 ID 수정 정보 입력 -> 게시글 수정")
    @Test
    void ArticleIdAndModifiedInfo_UpdatingArticle_UpdatesArticle(){
        given(articleRepository.save(ArgumentMatchers.any(Article.class))).willReturn(null);

        articleService.updateArticle(1L, ArticleUpdateDto.of("title","content","hashtag"));

        BDDMockito.then(articleRepository).should().save(ArgumentMatchers.any(Article.class));
    }

    @DisplayName("게시글 ID 입력 -> 게시글 삭제")
    @Test
    void ArticleId_DeletingArticle_DeletesArticle(){
        willDoNothing().given(articleRepository).delete(any(Article.class));

        articleService.deleteArticle(1L);

        BDDMockito.then(articleRepository).should().delete(ArgumentMatchers.any(Article.class));
    }
}