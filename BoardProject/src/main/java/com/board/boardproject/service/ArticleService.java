package com.board.boardproject.service;

import com.board.boardproject.domain.SearchType;
import com.board.boardproject.dto.ArticleDto;
import com.board.boardproject.dto.ArticleUpdateDto;
import com.board.boardproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticles(long l) {
        return null;
    }

    public void saveArticle(ArticleDto articleDto) {
    }

    public void updateArticle(long articleId, ArticleUpdateDto articleUpdateDto) {
    }

    public void deleteArticle(long articleId) {
    }
}
