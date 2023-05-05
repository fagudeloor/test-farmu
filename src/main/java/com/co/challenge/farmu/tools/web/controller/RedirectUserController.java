package com.co.challenge.farmu.tools.web.controller;

import com.co.challenge.farmu.tools.services.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("farmu")
public class RedirectUserController {

    private final UrlShortenerService urlShortenerService;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String>  getRedirectUrl(@PathVariable("shortUrl") String shortUrl){

        log.debug("shortUrl: " + shortUrl);
        String url = urlShortenerService.getOriginalUrl(shortUrl);
        return new ResponseEntity<>(url, HttpStatus.OK);
    }
}
