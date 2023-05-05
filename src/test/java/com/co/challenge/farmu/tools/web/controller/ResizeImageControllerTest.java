package com.co.challenge.farmu.tools.web.controller;

import com.co.challenge.farmu.tools.services.ResizeImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ResizeImageController.class)
class ResizeImageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ResizeImageService resizeImageService;


    @Test
    void uploadImage() throws Exception {
        given(resizeImageService.resize(any())).willReturn("this is a test".getBytes(UTF_8));
        MockMultipartFile mockImage = new MockMultipartFile("image", "image.png", "application/JPG", new byte[]{1});

        mockMvc.perform(multipart("/api/tools/image/v1/resize")
                        .file(mockImage))
                .andExpect(status().isOk());
    }
}