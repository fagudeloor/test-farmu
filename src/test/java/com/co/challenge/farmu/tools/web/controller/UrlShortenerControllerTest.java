package com.co.challenge.farmu.tools.web.controller;

import com.co.challenge.farmu.tools.services.UrlShortenerService;
import com.co.challenge.farmu.tools.web.model.UrlDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UrlShortenerController.class)
class UrlShortenerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UrlShortenerService urlShortenerService;

    @Test
    void createShortUrl() throws Exception {
        given(urlShortenerService.getOriginalUrl(any())).willReturn("http://localhost:8080/farmu/hs");

        UrlDto urlDto = UrlDto.builder()
                .urlOrigin("https://reviewnprep.com/blog/pass-the-aws-cloud-practitioner-exam-with-these-tips/?utm_campaign=Blog&utm_medium=AllSocial&utm_source=AllSocialMedia")
                .build();

        String urlJson = objectMapper.writeValueAsString(urlDto);

        mockMvc.perform(post("/api/tools/shortener/v1/createShort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(urlJson))
                .andExpect(status().isCreated());
    }
}