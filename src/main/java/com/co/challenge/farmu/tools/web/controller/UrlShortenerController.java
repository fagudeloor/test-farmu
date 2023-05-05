package com.co.challenge.farmu.tools.web.controller;

import com.co.challenge.farmu.tools.web.model.UrlDto;
import com.co.challenge.farmu.tools.services.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tools/shortener/v1/")
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @Value("${prefix.url}")
    private String baseUrl;

    @PostMapping("createShort")
    public ResponseEntity<String> createShortUrl(@RequestBody UrlDto request){
        String shortUrl = urlShortenerService.createUrl(request);

        log.debug("---url value: " + baseUrl + shortUrl);
        return  new ResponseEntity<>(baseUrl + shortUrl, HttpStatus.CREATED);
    }

}
