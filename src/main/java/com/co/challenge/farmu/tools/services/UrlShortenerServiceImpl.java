package com.co.challenge.farmu.tools.services;

import com.co.challenge.farmu.tools.repositories.UrlShortenerRepository;
import com.co.challenge.farmu.tools.repositories.domain.Url;
import com.co.challenge.farmu.tools.utilities.UrlConverter;
import com.co.challenge.farmu.tools.services.mappers.UrlMapper;
import com.co.challenge.farmu.tools.web.model.UrlDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UrlShortenerRepository urlShortenerRepository;
    private final UrlMapper urlMapper;


    @Override
    public String createUrl(UrlDto request) {
        Url url = urlMapper.urlDtoToUrl(request);
        url = validateUrl(url);
        return url.getShortUrl();
    }

    /**
     * @param url
     * @return url
     * Valida si la url existe contra la base de datos para no insertar url repetidas
     */
    private Url validateUrl(Url url) {
        Url byLongUrl = urlShortenerRepository.findByLongUrl(url.getLongUrl());
        if(byLongUrl == null){
            urlShortenerRepository.save(url);
            url.setShortUrl(UrlConverter.idToShortURL(url.getId()));
            urlShortenerRepository.saveAndFlush(url);
            return url;
        }else{
            return byLongUrl;
        }
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        Integer id = UrlConverter.shortURLtoID(shortUrl);
        Url url = urlShortenerRepository.getReferenceById(id);
        return url.getLongUrl();
    }

}
