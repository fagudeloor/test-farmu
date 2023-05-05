package com.co.challenge.farmu.tools.web.controller;

import com.co.challenge.farmu.tools.services.UrlShortenerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RedirectUserController.class)
class RedirectUserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UrlShortenerService urlShortenerService;

    @Test
    void getRedirectUrl() throws Exception {
        //given(urlShortenerService.getOriginalUrl(any())).willReturn("http://mytesturl.com");

        mockMvc.perform(get("/farmu/" + "ll").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}