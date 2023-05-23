package com.opensource.hongroaddong.cloud.s3.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class MD5Strategy implements FileNameStrategy  {
    @Override
    public String encodeName(MultipartFile multipartFile) throws IOException {
        return DigestUtils.md5DigestAsHex(multipartFile.getBytes());
    }
}
