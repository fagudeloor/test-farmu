package com.co.challenge.farmu.tools.web.controller;

import com.co.challenge.farmu.tools.services.ResizeImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tools/image/v1")
public class ResizeImageController {

    private final ResizeImageService resizeImageService;

    @PostMapping(path = "/resize", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[]  uploadImage(@RequestParam("image") MultipartFile image)
            throws IOException {
        log.info("Request contains, File: " + image.getOriginalFilename());
        log.info("Request contains, size: " + image.getSize());
        log.info("Request contains, contentType: " + image.getContentType());
        byte[] imageResized = resizeImageService.resize(image);


        return imageResized;
    }
}
