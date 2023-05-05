package com.co.challenge.farmu.tools.services;

import com.co.challenge.farmu.tools.utilities.Base64File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class ResizeImageServiceImplTest {

    static ResizeImageServiceImpl resizeImageService;

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public static void setUp(){
        resizeImageService = new ResizeImageServiceImpl();
    }

    @Test
    void resize() throws IOException {
        MultipartFile mockImage = new MockMultipartFile("image", "image.jpeg", "image/jpeg", Base64.getDecoder().decode(Base64File.imageBase64));

        byte[] resize = resizeImageService.resize(mockImage);

        assertNotNull(resize);
    }
}