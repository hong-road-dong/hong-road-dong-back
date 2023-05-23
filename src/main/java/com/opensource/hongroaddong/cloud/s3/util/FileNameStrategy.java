package com.opensource.hongroaddong.cloud.s3.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileNameStrategy {
    String encodeName(MultipartFile multipartFile) throws IOException;
}
