package com.co.challenge.farmu.tools.services;

import com.co.challenge.farmu.tools.utilities.Constants;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class ResizeImageServiceImpl implements ResizeImageService {

    @Override
    public byte[] resize(MultipartFile multipartFile) throws IOException {

        log.info("bytes: " + multipartFile.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(multipartFile.getInputStream())
                .size(500, 1000)
                .outputFormat(Constants.JPG)
                .outputQuality(1)
                .toOutputStream(outputStream);
        byte[] data = outputStream.toByteArray();

        return data;
    }
}
