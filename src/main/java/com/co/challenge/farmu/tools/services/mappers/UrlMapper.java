package com.co.challenge.farmu.tools.services.mappers;

import com.co.challenge.farmu.tools.repositories.domain.Url;
import com.co.challenge.farmu.tools.web.model.UrlDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface UrlMapper {

    @Mapping(target="urlOrigin", source="longUrl")
    UrlDto urlToUrlDto(Url url);

    @Mapping(target="longUrl", source= "urlOrigin")
    Url urlDtoToUrl(UrlDto urlDto);

}
