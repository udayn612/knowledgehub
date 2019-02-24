package com.stackroute.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

    void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess);

    void deleteFileFromS3Bucket(String fileName);
}
