package com.board.boardproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class ArticleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false) private Article article; //게시글 ID
    @Setter private String content; //내용

    private LocalDateTime createAt; //생성 일시
    private String createdBy; //생성자
    private LocalDateTime modifiedAt; //수정 일시
    private String modifiedBy; //수정자
}
