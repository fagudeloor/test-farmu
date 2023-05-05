package com.co.challenge.farmu.tools.services;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ResizeImageService {

    public byte[] resize(MultipartFile image) throws IOException;
}
