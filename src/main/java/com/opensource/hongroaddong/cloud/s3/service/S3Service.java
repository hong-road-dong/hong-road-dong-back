package com.opensource.hongroaddong.cloud.s3.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.opensource.hongroaddong.cloud.s3.util.FileNameStrategy;
import com.opensource.hongroaddong.global.error.dto.ErrorCode;
import com.opensource.hongroaddong.global.error.exception.common.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@Service
public class S3Service {

    private final AmazonS3Client amazonS3Client;
    private final FileNameStrategy fileNameStrategy;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;

    public String uploadFile(MultipartFile multipartFile) throws IOException {
        validateFileExists(multipartFile);

        var fileName = fileNameStrategy.encodeName(multipartFile);

        var url = putS3(multipartFile, fileName);

        return url;
    }

    private void validateFileExists(MultipartFile uploadFile) {
        if (uploadFile.isEmpty()) {
            throw new BusinessException(ErrorCode.FILE_EMPTY_ERROR);
        }
    }

    private String putS3(MultipartFile uploadFile, String fileName) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(uploadFile.getContentType());

        try (InputStream inputStream = uploadFile.getInputStream()) {
            amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.FILE_UPLOAD_ERROR);
        }

        return amazonS3Client.getUrl(bucketName, fileName).toString();
    }

}
