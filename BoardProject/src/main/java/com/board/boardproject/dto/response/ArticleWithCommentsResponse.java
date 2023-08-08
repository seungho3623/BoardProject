package com.board.boardproject.dto.response;

import com.board.boardproject.dto.ArticleWithCommentsDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleWithCommentsResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String email,
        String nickname,
        String userid,
        Set<ArticleCommentResponse> articleCommentsResponse
) {

    public static ArticleWithCommentsResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String nickname, String userId, Set<ArticleCommentResponse> articleCommentResponses) {
        return new ArticleWithCommentsResponse(id, title, content, hashtag, createdAt, email, nickname, userId, articleCommentResponses);
    }

    public static ArticleWithCommentsResponse from(ArticleWithCommentsDto article) {
        String nickname = article.userAccountDto().nickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = article.userAccountDto().userId();
        }

        return new ArticleWithCommentsResponse(
                article.id(),
                article.title(),
                article.content(),
                article.hashtag(),
                article.createdAt(),
                article.userAccountDto().email(),
                nickname,
                article.userAccountDto().userId(),
                article.articleCommentDtos().stream()
                        .map(ArticleCommentResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }

}