package com.co.challenge.farmu.tools.repositories.domain;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Image {

    @Id
    private String id;

    private String title;

    //private Binary image;
}
