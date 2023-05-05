package com.co.challenge.farmu.tools.services;


import com.co.challenge.farmu.tools.web.model.UrlDto;

public interface UrlShortenerService {

    public String createUrl(UrlDto request);

    public String getOriginalUrl(String shortUrl);
}
