package com.board.boardproject.controller;

import com.board.boardproject.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@DisplayName("View Controller - Articles")
@Import(SecurityConfig.class)
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {
    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[View][Get] Articles List Page")
    @Test
    public void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception{
        //Given

        //When & Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("articles"));
    }

    @DisplayName("[View][Get] Article Detail Page")
    @Test
    public void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception{
        //Given

        //When & Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("article"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("articleComments"));
    }

    @Disabled("구현 중")
    @DisplayName("[View][Get] Article Search Page")
    @Test
    public void givenNothing_whenRequestingArticleSearchView_thenReturnsArticleSearchView() throws Exception{
        //Given

        //When & Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.model().attributeExists("article/search"));
    }

    @Disabled("구현 중")
    @DisplayName("[View][Get] Article HashTag Search Page")
    @Test
    public void givenNothing_whenRequestingArticleHashTagSearchView_thenReturnsArticleHashTagSearchView() throws Exception{
        //Given

        //When & Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.model().attributeExists("article/search-hashtag"));
    }
}