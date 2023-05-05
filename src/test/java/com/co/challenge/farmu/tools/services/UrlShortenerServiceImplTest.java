package com.co.challenge.farmu.tools.services;

import com.co.challenge.farmu.tools.repositories.UrlShortenerRepository;
import com.co.challenge.farmu.tools.repositories.domain.Url;
import com.co.challenge.farmu.tools.services.mappers.UrlMapper;
import com.co.challenge.farmu.tools.web.model.UrlDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class UrlShortenerServiceImplTest {

    private UrlShortenerServiceImpl urlShortenerService;

    @Mock
    private UrlShortenerRepository urlShortenerRepository;
    private AutoCloseable closeable;
    @Mock
    private UrlMapper urlMapper;

    @BeforeEach
    public void setUp(){
        closeable = MockitoAnnotations.openMocks(this);
        urlShortenerService = new UrlShortenerServiceImpl(urlShortenerRepository, urlMapper);
    }

    @Test
    void createUrl() {
        UrlDto urlDtoMock = UrlDto.builder()
                .urlOrigin("http://google.com")
                .build();

        Url urlMock = Url.builder()
                .longUrl("http://google.com")
                .id(505)
                .build();

        when(urlShortenerRepository.findByLongUrl(anyString())).thenReturn(null);
        when(urlMapper.urlDtoToUrl(any())).thenReturn(urlMock);
        String url = urlShortenerService.createUrl(urlDtoMock);
        assertTrue(url.length()<urlDtoMock.getUrlOrigin().length());
    }

    @Test
    void createUrlWhenItExistInDB() {
        UrlDto urlDtoMock = UrlDto.builder()
                .urlOrigin("http://google.com")
                .build();

        Url urlMock = Url.builder()
                .longUrl("http://google.com")
                .id(505)
                .shortUrl("ij")
                .build();

        when(urlMapper.urlDtoToUrl(any())).thenReturn(urlMock);
        when(urlShortenerRepository.findByLongUrl(anyString())).thenReturn(urlMock);


        String url = urlShortenerService.createUrl(urlDtoMock);

        assertTrue(url.length() < urlDtoMock.getUrlOrigin().length());
    }

    @Test
    void getOriginalUrl() {
        Url urlMock = Url.builder()
                .longUrl("http://google.com")
                .id(505)
                .shortUrl("ij")
                .build();

        when(urlShortenerRepository.getReferenceById(anyInt())).thenReturn(urlMock);

        String longUrl = urlShortenerService.getOriginalUrl("ij");

        assertTrue(longUrl.length() > urlMock.getShortUrl().length());

    }
}