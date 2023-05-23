package com.opensource.hongroaddong.cloud.s3.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Primary
public class FileDateStrategy implements FileNameStrategy {

    private static final String CATEGORY_PREFIX = "video";
    private static final String FILE_EXTENSION_SEPARATOR = ".";

    @Override
    public String encodeName(MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        int fileExtensionIndex = originalFileName.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        String fileExtension = originalFileName.substring(fileExtensionIndex);
        String fileName = originalFileName.substring(0, fileExtensionIndex);
        String now = String.valueOf(System.currentTimeMillis());

        return CATEGORY_PREFIX + "/" + fileName + "_" + now + fileExtension;
    }

}