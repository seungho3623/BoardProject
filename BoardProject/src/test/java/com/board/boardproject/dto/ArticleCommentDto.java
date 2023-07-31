package com.board.boardproject.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleCommentDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String content
) {
    public static ArticleCommentDto of(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content) {
        return ArticleCommentDto.of(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }
}
