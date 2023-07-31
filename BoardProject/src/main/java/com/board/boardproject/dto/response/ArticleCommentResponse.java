package com.board.boardproject.dto.response;

import com.board.boardproject.dto.ArticleCommentDto;
import org.hibernate.boot.jaxb.internal.stax.LocalSchemaLocator;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleCommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        String email,
        String nickname
) implements Serializable {
    public static ArticleCommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String nickname) {
        return new ArticleCommentResponse(id, content, createdAt, email, nickname);
    }

    public static ArticleCommentResponse from(ArticleCommentDto articleCommentDto){
        String nickname = articleCommentDto.userAccountDto().nickname();
        if(nickname == null || nickname.isBlank()){
            nickname = articleCommentDto.userAccountDto().userId();
        }

        return new ArticleCommentResponse(
                articleCommentDto.id(),
                articleCommentDto.content(),
                articleCommentDto.createdAt(),
                articleCommentDto.userAccountDto().email(),
                nickname
        );
    }
}
