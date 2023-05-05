package com.co.challenge.farmu.tools.repositories;

import com.co.challenge.farmu.tools.repositories.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortenerRepository extends JpaRepository<Url, Integer> {

    Url findByLongUrl(String longUrl);
}
